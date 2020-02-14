//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.bd1_pd1;

import java.io.IOException;

import com.daxie.xops.bd1.BD1Manipulator;
import com.daxie.xops.pd1.PD1Manipulator;

public class MirroredMission {
	public static void main(String[] args) {
		final String bd1_orig_filename = "./temp.bd1";
		final String bd1_dest_filename = "./temp2.bd1";
		final String pd1_orig_filename = "./temp.pd1";
		final String pd1_dest_filename = "./temp2.pd1";

		BD1Manipulator bd1_manipulator = null;
		PD1Manipulator pd1_manipulator = null;
		try {
			bd1_manipulator = new BD1Manipulator(bd1_orig_filename);
			pd1_manipulator = new PD1Manipulator(pd1_orig_filename);
		} catch (IOException e) {
			System.out.println("File not found.");
			return;
		}

		bd1_manipulator.InvertZ();
		pd1_manipulator.InvertZ();

		bd1_manipulator.WriteAsBD1(bd1_dest_filename);
		pd1_manipulator.Write(pd1_dest_filename);
	}
}
