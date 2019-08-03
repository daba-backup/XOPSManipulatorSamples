//XOPSManipulator version:3.0.0

package com.daxie.testspace.xopsmanipulator.log;

import com.daxie.log.LogFile;

public class SetLogLevel {
	public static void main(String[] args) {
		int flags = LogFile.LOG_LEVEL_FATAL | LogFile.LOG_LEVEL_ERROR | LogFile.LOG_LEVEL_WARN | LogFile.LOG_LEVEL_INFO
				| LogFile.LOG_LEVEL_DEBUG;
		LogFile.SetLogLevelFlags(flags);
		LogFile.WriteDebug("Test");

		flags = LogFile.LOG_LEVEL_ALL;
		LogFile.SetLogLevelFlags(flags);
		LogFile.WriteTrace("Test2");
	}
}
