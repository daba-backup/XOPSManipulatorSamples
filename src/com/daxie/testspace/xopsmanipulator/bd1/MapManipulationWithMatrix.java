package com.daxie.testspace.xopsmanipulator.bd1;

import java.io.IOException;

import com.daxie.basis.matrix.Matrix;
import com.daxie.basis.matrix.MatrixFunctions;
import com.daxie.basis.vector.VectorFunctions;
import com.daxie.tool.MathFunctions;
import com.daxie.xops.bd1.BD1Manipulator;

public class MapManipulationWithMatrix {
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

		// Make matrices.
		// Rotate 30 degrees around x-axis
		Matrix rot_x = MatrixFunctions.MGetRotX(MathFunctions.DegToRad(30.0f));
		// Rotate 60 degrees around y-axis
		Matrix rot_y = MatrixFunctions.MGetRotY(MathFunctions.DegToRad(60.0f));
		// Rotate 45 degrees around z-axis
		Matrix rot_z = MatrixFunctions.MGetRotZ(MathFunctions.DegToRad(45.0f));
		// Translate +400 coordinates along y-axis
		Matrix translate = MatrixFunctions.MGetTranslate(VectorFunctions.VGet(0.0f, 400.0f, 0.0f));

		// Multiply matrices.
		Matrix m = MatrixFunctions.MMult(translate, rot_z);
		m = MatrixFunctions.MMult(m, rot_y);
		m = MatrixFunctions.MMult(m, rot_x);

		// Set the matrix to the manipulator.
		bd1_manipulator.SetMatrix(m);

		bd1_manipulator.WriteAsBD1(bd1_dest_filename);
	}
}
