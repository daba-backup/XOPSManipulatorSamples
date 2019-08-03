//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.mif;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.daxie.xops.mif.MIFManipulator;
import com.daxie.xops.mif.MissionInfo;

public class GetMissionInfo {
	public static void main(String[] args) {
		final String mif_filename = "./temp.mif";
		final String encoding = "Shift-JIS";

		MIFManipulator mif_manipulator = null;
		try {
			mif_manipulator = new MIFManipulator(mif_filename, encoding);
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

		MissionInfo mif = mif_manipulator.GetMissionInfo();

		System.out.println("[Mission name]");
		System.out.println(mif.GetMissionName());
		System.out.println("[Mission formal name]");
		System.out.println(mif.GetMissionFormalName());
		System.out.println("[BD1 filename]");
		System.out.println(mif.GetBD1Filename());
		System.out.println("[PD1 filename]");
		System.out.println(mif.GetPD1Filename());
		System.out.println("[Sky type]");
		System.out.println(mif.GetSkyType());
		System.out.println("[Extra hitcheck]");
		System.out.println(mif.GetExtraHitcheckFlag());
		System.out.println("[Darken screen]");
		System.out.println(mif.GetDarkenScreenFlag());
		System.out.println("[Article info filename]");
		System.out.println(mif.GetArticleInfoFilename());
		System.out.println("[Image 1 filename]");
		System.out.println(mif.GetImage1Filename());
		System.out.println("[Image 2 filename]");
		System.out.println(mif.GetImage2Filename());

		List<String> briefing_text = mif.GetBriefingText();
		System.out.println("[Briefing text]");
		for (String line : briefing_text) {
			System.out.println(line);
		}
	}
}
