//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.exe;

import java.io.FileNotFoundException;

import com.daxie.xops.exe.XOPSExeManipulator;
import com.daxie.xops.weapon.WeaponData;
import com.daxie.xops.xgs.XGSManipulator;

//Port weapon data acquired from a XGS file to an exe file of XOPS.
public class PortWeaponDataToXOPSExe {
	public static void main(String[] args) {
		final String xgs_filename = "./temp.xgs";
		final String xops_filename = "./xops0975t.exe";

		XGSManipulator xgs_manipulator = null;
		try {
			xgs_manipulator = new XGSManipulator(xgs_filename);
		} catch (FileNotFoundException e) {
			System.out.println("File not found. filename:" + xgs_filename);
			return;
		}

		WeaponData[] weapon_data_array = xgs_manipulator.GetWeaponDataArray();

		XOPSExeManipulator exe_manipulator = new XOPSExeManipulator();
		exe_manipulator.SetWeaponDataArray(weapon_data_array);

		try {
			exe_manipulator.Write(xops_filename, true);
		} catch (FileNotFoundException e) {
			System.out.println("File not found. filename:" + xops_filename);
			return;
		}
	}
}