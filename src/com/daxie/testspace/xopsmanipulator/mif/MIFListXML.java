package com.daxie.testspace.xopsmanipulator.mif;

import java.io.UnsupportedEncodingException;

import com.daxie.xops.mif.MIFList;

public class MIFListXML {
	public static void main(String[] args) {
		final String directory_name = "./addon";
		final String xml_filename = "./addon_list.xml";

		MIFList mif_list = null;
		try {
			mif_list = new MIFList(directory_name, "Shift-JIS");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding.");
			return;
		}

		mif_list.WriteXML(xml_filename, MIFList.ALL);
	}
}
