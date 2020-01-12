//XOPSManipulator version:6.0.0

package com.daxie.testspace.xopsmanipulator.xms;

import java.io.FileNotFoundException;

import com.daxie.xops.properties.entity.weapon.WeaponData;
import com.daxie.xops.properties.xms.xgs.XGSManipulator;

public class LoadXGS {
	public static void main(String[] args) {
		final String xgs_filename = "./temp.xgs";

		XGSManipulator xgs_manipulator = null;
		try {
			xgs_manipulator = new XGSManipulator(xgs_filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}

		WeaponData[] weapon_data_array = xgs_manipulator.GetWeaponDataArray();
		for (int i = 0; i < weapon_data_array.length; i++) {
			System.out.println("[" + i + "]");
			System.out.println(weapon_data_array[i]);
		}
	}
}
