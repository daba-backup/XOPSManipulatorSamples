package com.daxie.testspace.xopsmanipulator.xms;

import java.io.IOException;

import com.daxie.xops.properties.xms.xcs.XCSManipulator;

public class WriteXCS {
	public static void main(String[] args) {
		final String xcs_orig_filename = "./temp.xcs";
		final String xcs_dest_filename = "./temp2.xcs";

		XCSManipulator xcs_manipulator = null;
		try {
			xcs_manipulator = new XCSManipulator(xcs_orig_filename);
		} catch (IOException e) {
			System.out.println("File not found.");
			return;
		}

		xcs_manipulator.Write(xcs_dest_filename);
	}
}
