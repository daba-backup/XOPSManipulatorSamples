package com.daxie.testspace.xopsmanipulator.xms;

import java.io.IOException;

import com.daxie.xops.properties.xms.ids.IDSManipulator;

public class WriteIDS {
	public static void main(String[] args) {
		final String ids_orig_filename = "./temp.ids";
		final String ids_dest_filename = "./temp2.ids";

		IDSManipulator ids_manipulator = null;
		try {
			ids_manipulator = new IDSManipulator(ids_orig_filename);
		} catch (IOException e) {
			System.out.println("Error");
			return;
		}

		ids_manipulator.Write(ids_dest_filename);
	}
}
