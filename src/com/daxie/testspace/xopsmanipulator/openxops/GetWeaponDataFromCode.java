//XOPSManipulator version:6.0.0

package com.daxie.testspace.xopsmanipulator.openxops;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

import com.daxie.xops.properties.entity.weapon.WeaponData;
import com.daxie.xops.properties.openxops.WeaponDataCodeParser;

public class GetWeaponDataFromCode {
	public static void main(String[] args) {
		final String code_filename = "./weapon_data.txt";

		WeaponDataCodeParser code_parser = null;
		try {
			code_parser = new WeaponDataCodeParser(code_filename, "Shift-JIS");
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding.");
			return;
		}

		TreeMap<Integer, WeaponData> weapon_data_map = code_parser.GetWeaponDataOrderedMap();
		for (Map.Entry<Integer, WeaponData> entry : weapon_data_map.entrySet()) {
			System.out.println("[" + entry.getKey() + "]");
			System.out.println(entry.getValue());
		}
	}
}