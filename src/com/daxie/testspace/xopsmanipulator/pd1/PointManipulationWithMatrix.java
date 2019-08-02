//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.pd1;

import java.io.FileNotFoundException;

import com.daxie.basis.matrix.Matrix;
import com.daxie.basis.matrix.MatrixFunctions;
import com.daxie.basis.vector.VectorFunctions;
import com.daxie.tool.MathFunctions;
import com.daxie.xops.pd1.PD1Manipulator;

public class PointManipulationWithMatrix {
	public static void main(String[] args) {
		final String pd1_orig_filename = "./temp.pd1";
		final String pd1_dest_filename = "./temp2.pd1";

		PD1Manipulator pd1_manipulator = null;
		try {
			pd1_manipulator = new PD1Manipulator(pd1_orig_filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
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
		pd1_manipulator.SetMatrix(m);

		pd1_manipulator.Write(pd1_dest_filename);
	}
}
