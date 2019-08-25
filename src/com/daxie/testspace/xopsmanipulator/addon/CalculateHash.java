//XOPSManipulator version:4.0.1

package com.daxie.testspace.xopsmanipulator.addon;

import com.daxie.xops.addon.AddonHashCalculator;

public class CalculateHash {
	public static void main(String[] args) {
		AddonHashCalculator ahc = new AddonHashCalculator("SHA-256");

		ahc.CalculateBD1Hash("./temp.bd1");
		ahc.CalculatePD1Hash("./temp.pd1");
		ahc.CalculateMIFHash("./temp.mif");

		if (ahc.CalculateCombinedHash() < 0) {
			System.out.println("Error");
			return;
		}

		String bd1_hash = ahc.GetBD1Hash();
		String pd1_hash = ahc.GetPD1Hash();
		String mif_hash = ahc.GetMIFHash();
		String combined_hash = ahc.GetCombinedHash();

		System.out.println("BD1:" + bd1_hash);
		System.out.println("PD1:" + pd1_hash);
		System.out.println("MIF:" + mif_hash);
		System.out.println("Combined:" + combined_hash);
	}
}
