package com.daxie.testspace.xopsmanipulator.bd1;

import java.io.IOException;

import com.daxie.basis.vector.VectorFunctions;
import com.daxie.tool.MathFunctions;
import com.daxie.xops.bd1.BD1Manipulator;

public class MapManipulation {
	public static void main(String[] args) {
		final String bd1_orig_filename = "./temp.bd1";
		final String bd1_dest_filename = "./temp2.bd1";

		BD1Manipulator bd1_manipulator = null;
		try {
			bd1_manipulator = new BD1Manipulator(bd1_orig_filename);
		} catch (IOException e) {
			System.out.println("File not found.");
			return;
		}

		// Translate
		bd1_manipulator.Translate(VectorFunctions.VGet(0.0f, 100.0f, 0.0f));
		// Rescale
		bd1_manipulator.Rescale(VectorFunctions.VGet(2.0f, 2.0f, 2.0f));
		// Rotate
		float rad = MathFunctions.DegToRad(45.0f);
		bd1_manipulator.Rotate(VectorFunctions.VGet(0.0f, rad, 0.0f));

		bd1_manipulator.WriteAsBD1(bd1_dest_filename);
	}
}
