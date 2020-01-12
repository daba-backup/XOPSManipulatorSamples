//XOPSManipulator version:6.0.0

package com.daxie.testspace.xopsmanipulator.exe;

import java.io.FileNotFoundException;

import com.daxie.xops.properties.entity.character.CharacterData;
import com.daxie.xops.properties.entity.weapon.WeaponData;
import com.daxie.xops.properties.exe.XOPSExeManipulator;

public class LoadDataFromXOPSExe {
	public static void main(String[] args) {
		final String xops_filename = "./xops0975t.exe";

		XOPSExeManipulator exe_manipulator = null;
		try {
			exe_manipulator = new XOPSExeManipulator(xops_filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}

		WeaponData[] weapon_data_array = exe_manipulator.GetWeaponDataArray();
		CharacterData[] character_data_array = exe_manipulator.GetCharacterDataArray();

		for (int i = 0; i < weapon_data_array.length; i++) {
			System.out.println("[" + i + "]");
			System.out.println(weapon_data_array[i]);
		}
		for (int i = 0; i < character_data_array.length; i++) {
			System.out.println("[" + i + "]");
			System.out.println(character_data_array[i]);
		}
	}
}
