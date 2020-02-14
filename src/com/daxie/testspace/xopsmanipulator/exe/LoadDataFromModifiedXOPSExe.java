package com.daxie.testspace.xopsmanipulator.exe;

import java.io.IOException;

import com.daxie.xops.properties.entity.character.CharacterData;
import com.daxie.xops.properties.entity.weapon.WeaponData;
import com.daxie.xops.properties.exe.XOPSExeManipulator;

//This sample shows how to load data from a modified exe.
//This sample aims to load data from Ghillie In the Mist.
public class LoadDataFromModifiedXOPSExe {
	public static void main(String[] args) {
		final String xops_filename = "./Ghillie In the Mist.exe";

		XOPSExeManipulator exe_manipulator = null;
		try {
			// Specify start addresses of each data block.
			//
			// [Start address]
			// Weapon data:0x0005E32C
			// Character data:0x000671E4
			// Weapon name:0x0005E864
			exe_manipulator = new XOPSExeManipulator(xops_filename, 0x0005E32C, 0x000671E4, 0x0005E864);
		} catch (IOException e) {
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
