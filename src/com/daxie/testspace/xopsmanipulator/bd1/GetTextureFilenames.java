//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.bd1;

import java.io.IOException;

import com.daxie.xops.bd1.BD1Manipulator;

public class GetTextureFilenames {
	public static void main(String[] args) {
		final String bd1_filename = "./temp.bd1";

		BD1Manipulator bd1_manipulator = null;
		try {
			bd1_manipulator = new BD1Manipulator(bd1_filename);
		} catch (IOException e) {
			System.out.println("File not found.");
			return;
		}

		for (int i = 0; i < 10; i++) {
			String texture_filename = bd1_manipulator.GetTextureFilename(i);
			System.out.println(texture_filename);
		}
	}
}
