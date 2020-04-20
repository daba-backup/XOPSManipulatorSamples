package com.daxie.testspace.xopsmanipulator.config;

import java.io.IOException;

import com.daxie.xops.properties.config.Config;
import com.daxie.xops.properties.config.ConfigManipulator;

public class GetConfig {
	public static void main(String[] args) {
		final String config_filename = "./config.dat";

		ConfigManipulator config_manipulator;
		try {
			config_manipulator = new ConfigManipulator(config_filename);
		} catch (IOException e) {
			System.out.println("Error");
			return;
		}

		Config config = config_manipulator.GetConfig();
		System.out.println(config);
	}
}
