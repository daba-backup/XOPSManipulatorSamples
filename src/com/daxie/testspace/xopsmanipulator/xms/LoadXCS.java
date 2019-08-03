//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.xms;

import java.io.FileNotFoundException;

import com.daxie.xops.character.CharacterData;
import com.daxie.xops.xcs.XCSManipulator;

public class LoadXCS {
	public static void main(String[] args) {
		final String xcs_filename = "./temp.xcs";

		XCSManipulator xcs_manipulator = null;
		try {
			xcs_manipulator = new XCSManipulator(xcs_filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}

		CharacterData[] character_data_array = xcs_manipulator.GetCharacterDataArray();
		for (int i = 0; i < character_data_array.length; i++) {
			System.out.println("[" + i + "]");
			System.out.println(character_data_array[i]);
		}
	}
}
