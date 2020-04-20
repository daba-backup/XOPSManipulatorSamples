package com.daxie.testspace.xopsmanipulator.openxops;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.daxie.xops.properties.entity.character.CharacterData;
import com.daxie.xops.properties.openxops.CharacterDataCodeParser;

public class GetCharacterDataFromCode {
	public static void main(String[] args) {
		final String code_filename = "./character_data.txt";

		CharacterDataCodeParser code_parser = null;
		try {
			code_parser = new CharacterDataCodeParser(code_filename, "Shift-JIS");
		} catch (IOException e) {
			System.out.println("Error");
			return;
		}

		HashMap<Integer, CharacterData> character_data_map = code_parser.GetCharacterDataMap();
		for (Map.Entry<Integer, CharacterData> entry : character_data_map.entrySet()) {
			System.out.println("[" + entry.getKey() + "]");
			System.out.println(entry.getValue());
		}
	}
}