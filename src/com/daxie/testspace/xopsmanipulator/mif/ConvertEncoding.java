//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.mif;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

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
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding.");
			return;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}

		try {
			mif_manipulator.Write(mif_dest_filename, dest_encoding);
		} catch (FileNotFoundException e) {
			System.out.println("Failed to create a MIF file.");
			return;
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding.");
			return;
		}
	}
}
