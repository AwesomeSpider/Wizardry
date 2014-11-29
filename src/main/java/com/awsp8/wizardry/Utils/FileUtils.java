package com.awsp8.wizardry.Utils;

import java.io.File;

import com.awsp8.wizardry.Wizardry;

public class FileUtils {

	public static void createDirectory(File file, String name){
		if (file.exists() == false)
			file.mkdir();
		
		if (file.exists() == true)
			Wizardry.log.info("[File Utiliy] File '" + name + "' Successfully Created.");
	}
}
