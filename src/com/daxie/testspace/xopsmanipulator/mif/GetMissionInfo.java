package com.daxie.testspace.xopsmanipulator.mif;

import java.io.IOException;

import com.daxie.xops.mif.MIFManipulator;
import com.daxie.xops.mif.MissionInfo;

public class GetMissionInfo {
	public static void main(String[] args) {
		final String mif_filename = "./temp.mif";
		final String encoding = "Shift-JIS";

		MIFManipulator mif_manipulator = null;
		try {
			mif_manipulator = new MIFManipulator(mif_filename, encoding);
		} catch (IOException e) {
			System.out.println("Error");
			return;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}

		MissionInfo mif = mif_manipulator.GetMissionInfo();
		System.out.println(mif);
	}
}
