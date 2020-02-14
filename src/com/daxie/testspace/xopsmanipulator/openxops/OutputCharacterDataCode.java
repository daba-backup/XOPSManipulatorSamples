package com.daxie.testspace.xopsmanipulator.openxops;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.daxie.xops.properties.entity.character.CharacterData;
import com.daxie.xops.properties.openxops.CharacterDataCodeOutputter;
import com.daxie.xops.properties.xms.xcs.XCSManipulator;

public class OutputCharacterDataCode {
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

		List<CharacterData> character_data_list = new ArrayList<>();
		for (int i = 0; i < character_data_array.length; i++) {
			character_data_list.add(character_data_array[i]);
		}

		CharacterDataCodeOutputter cdco = new CharacterDataCodeOutputter(character_data_list);

		String code = cdco.GetCharacterDataSourceCode();
		System.out.println(code);
	}
}
