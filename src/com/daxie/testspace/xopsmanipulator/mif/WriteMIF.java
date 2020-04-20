package com.daxie.testspace.xopsmanipulator.mif;

import java.io.IOException;

import com.daxie.xops.mif.MIFManipulator;
import com.daxie.xops.mif.MissionInfo;

public class WriteMIF {
	public static void main(String[] args) {
		final String mif_orig_filename = "./temp.mif";
		final String mif_dest_filename = "./temp2.mif";
		final String encoding = "Shift-JIS";

		MIFManipulator mif_manipulator = null;
		try {
			mif_manipulator = new MIFManipulator(mif_orig_filename, encoding);
		} catch (IOException e) {
			System.out.println("Error");
			return;
		}
		MissionInfo mif = mif_manipulator.GetMissionInfo();

		// Convert the mission name to upper case.
		String mission_name = mif.GetMissionName();
		mission_name = mission_name.toUpperCase();
		mif.SetMissionName(mission_name);

		mif_manipulator.SetMissionInfo(mif);

		mif_manipulator.Write(mif_dest_filename, encoding);
	}
}
