package com.daxie.testspace.xopsmanipulator.bd1;

import com.daxie.xops.bd1.BD1Generator;
import com.daxie.xops.bd1.BD1UniformGenerator;

public class GenerateCubes {
	public static void main(String[] args) {
		BD1Generator bd1_generator;

		// Generate blocks according to a uniform distribution.
		bd1_generator = new BD1UniformGenerator();

		// Generate blocks according to the normal distribution.
		// bd1_generator=new BD1NormalGenerator();

		// Set texture filenames.
		bd1_generator.SetTextureFilename(0, "tex1blue.bmp");
		bd1_generator.SetTextureFilename(1, "tex1gray.bmp");
		bd1_generator.SetTextureFilename(2, "tex1red.bmp");
		bd1_generator.SetTextureFilename(3, "tex1white.bmp");

		// Generate cubes.
		bd1_generator.GenerateCubes(160, 20.0f, 500.0f);

		// Randomly set textures to every block.
		bd1_generator.RandomizeTextureIDsPerBlock(4);

		// Write out blocks into a BD1 file.
		bd1_generator.WriteAsBD1("./temp.bd1", 500.0f);
	}
}
