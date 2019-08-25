//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.pd1;

import java.io.FileNotFoundException;

import com.daxie.tool.MathFunctions;
import com.daxie.xops.pd1.PD1Manipulator;

public class RotateDirection {
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

		float rad = MathFunctions.DegToRad(45.0f);
		pd1_manipulator.RotateDirection(rad);

		pd1_manipulator.Write(pd1_dest_filename);
	}
}