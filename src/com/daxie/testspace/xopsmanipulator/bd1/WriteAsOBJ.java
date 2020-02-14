//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.bd1;

import java.io.IOException;

import com.daxie.xops.bd1.BD1Manipulator;

public class WriteAsOBJ {
	public static void main(String[] args) {
		final String bd1_orig_filename = "./temp.bd1";
		final String obj_dest_filename = "./temp.obj";

		BD1Manipulator bd1_manipulator = null;
		try {
			bd1_manipulator = new BD1Manipulator(bd1_orig_filename);
		} catch (IOException e) {
			System.out.println("File not found.");
			return;
		}

		// The default coordinate system in DirectX is left-handed.
		// Invert the blocks in case the coordinate system you want is right-handed.
		bd1_manipulator.InvertZ();

		bd1_manipulator.WriteAsOBJ(obj_dest_filename);
	}
}
