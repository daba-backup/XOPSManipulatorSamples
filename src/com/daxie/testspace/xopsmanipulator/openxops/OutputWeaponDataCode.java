package com.daxie.testspace.xopsmanipulator.openxops;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.daxie.xops.properties.entity.weapon.WeaponData;
import com.daxie.xops.properties.openxops.WeaponDataCodeOutputter;
import com.daxie.xops.properties.xms.xgs.XGSManipulator;

public class OutputWeaponDataCode {
	public static void main(String[] args) {
		final String xgs_filename = "./temp.xgs";

		XGSManipulator xgs_manipulator = null;
		try {
			xgs_manipulator = new XGSManipulator(xgs_filename);
		} catch (IOException e) {
			System.out.println("File not found.");
			return;
		}

		WeaponData[] weapon_data_array = xgs_manipulator.GetWeaponDataArray();

		List<WeaponData> weapon_data_list = new ArrayList<>();
		for (int i = 0; i < weapon_data_array.length; i++) {
			weapon_data_list.add(weapon_data_array[i]);
		}

		WeaponDataCodeOutputter wdco = new WeaponDataCodeOutputter(weapon_data_list);

		String code = wdco.GetWeaponDataSourceCode();
		System.out.println(code);
	}
}
