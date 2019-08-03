//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.log;

import com.daxie.log.LogFile;

public class StopUsingLog {
	public static void main(String[] args) {
		LogFile.SetLogLevelFlags(LogFile.LOG_LEVEL_ALL);
		LogFile.SetOutputLogFlag(false);

		LogFile.WriteInfo("Test");
	}
}
