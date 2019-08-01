//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.bd1;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

import com.daxie.basis.matrix.Matrix;
import com.daxie.basis.matrix.MatrixFunctions;
import com.daxie.basis.vector.Vector;
import com.daxie.basis.vector.VectorFunctions;
import com.daxie.xops.bd1.BD1Block;
import com.daxie.xops.bd1.BD1Manipulator;

public class RandomTranslationOfVertices {
	public static void main(String[] args) {
		final String bd1_orig_filename = "./temp.bd1";
		final String bd1_dest_filename = "./temp2.bd1";

		BD1Manipulator bd1_manipulator = null;
		try {
			bd1_manipulator = new BD1Manipulator(bd1_orig_filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}

		Random random = new Random();
		List<BD1Block> blocks = bd1_manipulator.GetBlocks();

		final float SCALE = 0.05f;

		for (BD1Block block : blocks) {
			Vector[] vertex_positions = block.GetVertexPositions();

			for (int i = 0; i < vertex_positions.length; i++) {
				float offset_x = random.nextFloat() * SCALE;
				float offset_y = random.nextFloat() * SCALE;
				float offset_z = random.nextFloat() * SCALE;

				int sign_x = random.nextInt(2);
				int sign_y = random.nextInt(2);
				int sign_z = random.nextInt(2);

				float scale_x, scale_y, scale_z;
				if (sign_x == 0)
					scale_x = 1.0f + offset_x;
				else
					scale_x = 1.0f - offset_x;
				if (sign_y == 0)
					scale_y = 1.0f + offset_y;
				else
					scale_y = 1.0f - offset_y;
				if (sign_z == 0)
					scale_z = 1.0f + offset_z;
				else
					scale_z = 1.0f - offset_z;

				// Get a transformation matrix.
				Matrix transformation = MatrixFunctions.MGetScale(VectorFunctions.VGet(scale_x, scale_y, scale_z));

				// Apply the transformation matrix to the vertex.
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
