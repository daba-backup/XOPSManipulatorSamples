package com.daxie.testspace.xopsmanipulator.xms;

import java.io.IOException;

import com.daxie.xops.properties.entity.weapon.WeaponData;
import com.daxie.xops.properties.xms.ids.IDSManipulator;

public class LoadIDS {
	public static void main(String[] args) {
		final String ids_filename = "./temp.ids";

		IDSManipulator ids_manipulator = null;
		try {
			ids_manipulator = new IDSManipulator(ids_filename);
		} catch (IOException e) {
			System.out.println("File not found.");
			return;
		}

		WeaponData weapon_data = ids_manipulator.GetWeaponData();
		System.out.println(weapon_data);
	}
}
