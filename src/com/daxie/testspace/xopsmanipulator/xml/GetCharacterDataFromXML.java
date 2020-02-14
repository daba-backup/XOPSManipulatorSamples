package com.daxie.testspace.xopsmanipulator.xml;

import java.util.Map;

import com.daxie.xops.properties.entity.character.CharacterData;
import com.daxie.xops.properties.xml.CharacterDataXMLParser;

public class GetCharacterDataFromXML {
	public static void main(String[] args) {
		final String xml_filename = "./character_data.xml";

		CharacterDataXMLParser cdxp = new CharacterDataXMLParser();
		// cdxp.SetOpenXOPSCompatibleFlag(false);
		cdxp.LoadCharacterDataXML(xml_filename);

		Map<Integer, CharacterData> character_data_map = cdxp.GetCharacterDataMap();

		for (Map.Entry<Integer, CharacterData> entry : character_data_map.entrySet()) {
			System.out.println("[" + entry.getKey() + "]");
			System.out.println(entry.getValue());
		}
	}
}
