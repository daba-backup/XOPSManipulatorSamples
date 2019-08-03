//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.log;

import com.daxie.log.LogFile;

public class MakeLogFile {
	public static void main(String[] args) {
		LogFile.SetLogDirectory("./Log");
		LogFile.SetLogFilename("log.txt");
		LogFile.SetLogLevelFlags(LogFile.LOG_LEVEL_ALL);

		LogFile.OpenLogFile();// Open a log file.
		// --------------------
		// Log output is enabled.

		LogFile.WriteDebug("Test");

		// --------------------
		LogFile.CloseLogFile();// Close the log file.
	}
}
