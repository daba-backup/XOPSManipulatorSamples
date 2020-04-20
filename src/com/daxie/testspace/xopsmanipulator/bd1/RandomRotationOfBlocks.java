package com.daxie.testspace.xopsmanipulator.bd1;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import com.daxie.basis.matrix.Matrix;
import com.daxie.basis.matrix.MatrixFunctions;
import com.daxie.basis.vector.Vector;
import com.daxie.basis.vector.VectorFunctions;
import com.daxie.tool.MathFunctions;
import com.daxie.xops.bd1.BD1Block;
import com.daxie.xops.bd1.BD1Manipulator;

public class RandomRotationOfBlocks {
	public static void main(String[] args) {
		final String bd1_orig_filename = "./temp.bd1";
		final String bd1_dest_filename = "./temp2.bd1";

		BD1Manipulator bd1_manipulator = null;
		try {
			bd1_manipulator = new BD1Manipulator(bd1_orig_filename);
		} catch (IOException e) {
			System.out.println("Error");
			return;
		}

		Random random = new Random();
		Matrix rot_y = MatrixFunctions.MGetRotY(MathFunctions.DegToRad(45.0f));

		List<BD1Block> blocks = bd1_manipulator.GetBlocks();
		for (BD1Block block : blocks) {
			int rnd = random.nextInt(10);
			if (rnd % 2 == 0)
				continue;// Do nothing if rnd is an even number.

			Vector[] vertex_positions = block.GetVertexPositions();

			// Get the center of the block.
			Vector centroid = VectorFunctions.VGet(0.0f, 0.0f, 0.0f);
			for (int i = 0; i < vertex_positions.length; i++) {
				centroid = VectorFunctions.VAdd(centroid, vertex_positions[i]);
			}
			centroid = VectorFunctions.VScale(centroid, 1.0f / vertex_positions.length);

			// Get a matrix to translate the center of the block to the origin.
			Vector to_orig_vec = VectorFunctions.VSub(VectorFunctions.VGet(0.0f, 0.0f, 0.0f), centroid);
			Matrix to_orig_mat = MatrixFunctions.MGetTranslate(to_orig_vec);
			// Get a matrix to translate the center of the block to where it was before.
			Vector to_cent_vec = VectorFunctions.VScale(to_orig_vec, -1.0f);
			Matrix to_cent_mat = MatrixFunctions.MGetTranslate(to_cent_vec);

			// Get a transformation matrix.
			Matrix transformation = MatrixFunctions.MMult(to_cent_mat, rot_y);
			transformation = MatrixFunctions.MMult(transformation, to_orig_mat);

			// Apply the matrix to each vertex of the block.
			for (int i = 0; i < vertex_positions.length; i++) {
				vertex_positions[i] = VectorFunctions.VTransform(vertex_positions[i], transformation);
			}

			// Set vertex positions to the block.
			for (int i = 0; i < vertex_positions.length; i++) {
				block.SetVertexPosition(i, vertex_positions[i]);
			}
		}

		bd1_manipulator.SetBlocks(blocks);

		bd1_manipulator.WriteAsBD1(bd1_dest_filename);
	}
}
