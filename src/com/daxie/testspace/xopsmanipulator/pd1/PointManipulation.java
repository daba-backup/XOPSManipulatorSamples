//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.pd1;

import java.io.IOException;

import com.daxie.basis.vector.VectorFunctions;
import com.daxie.tool.MathFunctions;
import com.daxie.xops.pd1.PD1Manipulator;

public class PointManipulation {
	public static void main(String[] args) {
		final String pd1_orig_filename = "./temp.pd1";
		final String pd1_dest_filename = "./temp2.pd1";

		PD1Manipulator pd1_manipulator = null;
		try {
			pd1_manipulator = new PD1Manipulator(pd1_orig_filename);
		} catch (IOException e) {
			System.out.println("File not found.");
			return;
		}

		// Translate
		pd1_manipulator.Translate(VectorFunctions.VGet(0.0f, 100.0f, 0.0f));
		// Rescale
		pd1_manipulator.Rescale(VectorFunctions.VGet(2.0f, 2.0f, 2.0f));
		// Rotate
		float rad = MathFunctions.DegToRad(45.0f);
		pd1_manipulator.Rotate(VectorFunctions.VGet(0.0f, rad, 0.0f));

		pd1_manipulator.Write(pd1_dest_filename);
	}
}
