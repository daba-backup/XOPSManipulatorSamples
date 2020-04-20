package com.daxie.testspace.xopsmanipulator.xms;

import java.io.IOException;

import com.daxie.xops.properties.xms.xgs.XGSManipulator;

public class WriteXGS {
	public static void main(String[] args) {
		final String xgs_orig_filename = "./temp.xgs";
		final String xgs_dest_filename = "./temp2.xgs";

		XGSManipulator xgs_manipulator = null;
		try {
			xgs_manipulator = new XGSManipulator(xgs_orig_filename);
		} catch (IOException e) {
			System.out.println("Error");
			return;
		}

		xgs_manipulator.Write(xgs_dest_filename);
	}
}
