package com.daxie.testspace.xopsmanipulator.config;

import java.io.IOException;

import com.daxie.xops.properties.config.Config;
import com.daxie.xops.properties.config.ConfigManipulator;
import com.daxie.xops.properties.config.WindowMode;

public class WriteConfig {
	public static void main(String[] args) {
		final String config_orig_filename = "./config.dat";
		final String config_dest_filename = "./config2.dat";

		ConfigManipulator config_manipulator;
		try {
			config_manipulator = new ConfigManipulator(config_orig_filename);
		} catch (IOException e) {
			System.out.println("Error");
			return;
		}

		Config config = config_manipulator.GetConfig();
		config.SetWindowMode(WindowMode.WINDOW);
		config.SetName("Test");

		config_manipulator.SetConfig(config);

		config_manipulator.Write(config_dest_filename);
	}
}
