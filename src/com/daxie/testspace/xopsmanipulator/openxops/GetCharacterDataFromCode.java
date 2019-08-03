//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.openxops;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.daxie.xops.character.CharacterData;
import com.daxie.xops.openxops.CharacterDataCodeParser;

public class GetCharacterDataFromCode {
	public static void main(String[] args) {
		final String code_filename = "./character_data.txt";

		CharacterDataCodeParser code_parser = null;
		try {
			code_parser = new CharacterDataCodeParser(code_filename, "Shift-JIS");
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding.");
			return;
		}

		HashMap<Integer, CharacterData> character_data_map = code_parser.GetCharacterDataMap();
		for (Map.Entry<Integer, CharacterData> entry : character_data_map.entrySet()) {
			System.out.println("[" + entry.getKey() + "]");
			System.out.println(entry.getValue());
		}
	}
}