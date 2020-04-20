package com.daxie.testspace.xopsmanipulator.bd1;

import java.io.IOException;

import com.daxie.xops.bd1.BD1Manipulator;

public class GetBlockNum {
	public static void main(String[] args) {
		final String bd1_filename = "./temp.bd1";

		BD1Manipulator bd1_manipulator = null;
		try {
			bd1_manipulator = new BD1Manipulator(bd1_filename);
		} catch (IOException e) {
			System.out.println("Error");
			return;
		}

		int block_num = bd1_manipulator.GetBlockNum();
		System.out.println(block_num);
	}
}
