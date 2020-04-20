package com.daxie.testspace.xopsmanipulator.exe;

import java.io.IOException;

import com.daxie.xops.properties.exe.XOPSExeManipulator;

public class WriteDataToXOPSExe {
	public static void main(String[] args) {
		final String xops_orig_filename = "./xops0975t_orig.exe";
		final String xops_dest_filename = "./xops0975t_dest.exe";

		XOPSExeManipulator exe_manipulator = null;
		try {
			exe_manipulator = new XOPSExeManipulator(xops_orig_filename);
		} catch (IOException e) {
			System.out.println("Error");
			return;
		}

		exe_manipulator.Write(xops_dest_filename, true);
	}
}
