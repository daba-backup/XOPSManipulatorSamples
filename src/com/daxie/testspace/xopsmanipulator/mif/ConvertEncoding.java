package com.daxie.testspace.xopsmanipulator.mif;

import java.io.IOException;

import com.daxie.xops.mif.MIFManipulator;

public class ConvertEncoding {
	public static void main(String[] args) {
		final String mif_orig_filename = "./temp.mif";
		final String mif_dest_filename = "./temp2.mif";
		final String orig_encoding = "Shift-JIS";
		final String dest_encoding = "UTF-8";

		MIFManipulator mif_manipulator = null;
		try {
			mif_manipulator = new MIFManipulator(mif_orig_filename, orig_encoding);
		} catch (IOException e) {
			System.out.println("Error");
			return;
		}

		mif_manipulator.Write(mif_dest_filename, dest_encoding);
	}
}
