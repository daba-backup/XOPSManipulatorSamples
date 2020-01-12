//XOPSManipulator version:6.0.0

package com.daxie.testspace.xopsmanipulator.xms;

import java.io.FileNotFoundException;

import com.daxie.xops.properties.xms.xgs.XGSManipulator;

public class WriteXGS {
	public static void main(String[] args) {
		final String xgs_orig_filename = "./temp.xgs";
		final String xgs_dest_filename = "./temp2.xgs";

		XGSManipulator xgs_manipulator = null;
		try {
			xgs_manipulator = new XGSManipulator(xgs_orig_filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}

		xgs_manipulator.Write(xgs_dest_filename);
	}
}
