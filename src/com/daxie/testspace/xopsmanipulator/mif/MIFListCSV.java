package com.daxie.testspace.xopsmanipulator.mif;

import java.io.UnsupportedEncodingException;

import com.daxie.xops.mif.MIFList;

public class MIFListCSV {
	public static void main(String[] args) {
		final String directory_name = "./addon";
		final String csv_filename = "./addon_list.csv";

		MIFList mif_list = null;
		try {
			mif_list = new MIFList(directory_name, "Shift-JIS");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding.");
			return;
		}

		mif_list.WriteCSV(csv_filename, MIFList.ALL);
	}
}
