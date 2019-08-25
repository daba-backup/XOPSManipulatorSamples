//XOPSManipulator version:4.0.1

package com.daxie.testspace.xopsmanipulator.pd1;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

import com.daxie.tool.MathFunctions;
import com.daxie.xops.pd1.PD1Manipulator;
import com.daxie.xops.pd1.PD1Point;

public class RandomRotationOfDirection {
	public static void main(String[] args) {
		final String pd1_orig_filename = "./temp.pd1";
		final String pd1_dest_filename = "./temp2.pd1";

		PD1Manipulator pd1_manipulator = null;
		try {
			pd1_manipulator = new PD1Manipulator(pd1_orig_filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}

		Random random = new Random();

		List<PD1Point> points = pd1_manipulator.GetPoints();
		for (PD1Point point : points) {
			int deg = random.nextInt(360);
			float rad = MathFunctions.DegToRad(deg);

			float rotation = point.GetRotation();
			rotation += rad;
			point.SetRotation(rotation);
		}

		pd1_manipulator.SetPoints(points);

		pd1_manipulator.Write(pd1_dest_filename);
	}
}
