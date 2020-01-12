//XOPSManipulator version:6.0.0

package com.daxie.testspace.xopsmanipulator.xms;

import java.io.FileNotFoundException;

import com.daxie.xops.properties.xms.ids.IDSManipulator;

public class WriteIDS {
	public static void main(String[] args) {
		final String ids_orig_filename = "./temp.ids";
		final String ids_dest_filename = "./temp2.ids";

		IDSManipulator ids_manipulator = null;
		try {
			ids_manipulator = new IDSManipulator(ids_orig_filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}

		ids_manipulator.Write(ids_dest_filename);
	}
}
