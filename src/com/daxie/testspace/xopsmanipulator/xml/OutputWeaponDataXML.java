//XOPSManipulator version:6.0.0

package com.daxie.testspace.xopsmanipulator.xml;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.daxie.xops.properties.entity.weapon.WeaponData;
import com.daxie.xops.properties.xml.WeaponDataXMLOutputter;
import com.daxie.xops.properties.xms.xgs.XGSManipulator;

public class OutputWeaponDataXML {
	public static void main(String[] args) {
		final String xgs_filename = "./temp.xgs";
		final String xml_filename = "./weapon_data.xml";

		XGSManipulator xgs_manipulator = null;
		try {
			xgs_manipulator = new XGSManipulator(xgs_filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}

		WeaponData[] weapon_data_array = xgs_manipulator.GetWeaponDataArray();

		List<WeaponData> weapon_data_list = new ArrayList<>();
		for (int i = 0; i < weapon_data_array.length; i++) {
			weapon_data_list.add(weapon_data_array[i]);
		}

		WeaponDataXMLOutputter wdxo = new WeaponDataXMLOutputter(weapon_data_list);
		// cdxo.SetOpenXOPSCompatibleFlag(false);
		wdxo.WriteXML(xml_filename);
	}
}
