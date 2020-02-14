package com.daxie.testspace.xopsmanipulator.xms;

import java.io.IOException;

import com.daxie.xops.properties.entity.character.CharacterData;
import com.daxie.xops.properties.xms.xcs.XCSManipulator;

public class LoadXCS {
	public static void main(String[] args) {
		final String xcs_filename = "./temp.xcs";

		XCSManipulator xcs_manipulator = null;
		try {
			xcs_manipulator = new XCSManipulator(xcs_filename);
		} catch (IOException e) {
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
