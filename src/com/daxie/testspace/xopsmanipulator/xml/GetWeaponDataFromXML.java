//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.xml;

import java.util.Map;

import com.daxie.xops.weapon.WeaponData;
import com.daxie.xops.xml.WeaponDataXMLParser;

public class GetWeaponDataFromXML {
	public static void main(String[] args) {
		final String xml_filename = "./weapon_data.xml";

		WeaponDataXMLParser wdxp = new WeaponDataXMLParser();
		// wdxp.SetOpenXOPSCompatibleFlag(false);
		wdxp.LoadWeaponDataXML(xml_filename);

		Map<Integer, WeaponData> weapon_data_map = wdxp.GetWeaponDataMap();

		for (Map.Entry<Integer, WeaponData> entry : weapon_data_map.entrySet()) {
			System.out.println("[" + entry.getKey() + "]");
			System.out.println(entry.getValue());
		}
	}
}
