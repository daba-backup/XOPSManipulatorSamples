package com.daxie.testspace.xopsmanipulator.pd1;

import java.io.IOException;

import com.daxie.xops.pd1.PD1Manipulator;

public class GetPointNum {
	public static void main(String[] args) {
		final String pd1_filename = "./temp.pd1";

		PD1Manipulator pd1_manipulator = null;
		try {
			pd1_manipulator = new PD1Manipulator(pd1_filename);
		} catch (IOException e) {
			System.out.println("File not found.");
			return;
		}

		// Get the total number of points.
		int point_num = pd1_manipulator.GetPointNum();
		// Get the total number of characters.
		int character_num = pd1_manipulator.GetPointNum(1);

		System.out.println("point_num=" + point_num);
		System.out.println("character_num=" + character_num);
	}
}
