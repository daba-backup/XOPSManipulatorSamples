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
			System.out.println("Error");
			return;
		}

		bd1_manipulator.InvertZ();

		bd1_manipulator.WriteAsOBJ(obj_dest_filename);
	}
}
