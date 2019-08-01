//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.bd1;

import java.io.FileNotFoundException;

import com.daxie.xops.bd1.BD1Manipulator;

public class WriteAsBD1 {
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

		bd1_manipulator.WriteAsBD1(bd1_dest_filename);
	}
}
