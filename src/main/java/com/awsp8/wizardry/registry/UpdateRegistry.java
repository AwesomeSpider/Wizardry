package com.awsp8.wizardry.registry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import net.minecraft.util.EnumChatFormatting;

import com.awsp8.wizardry.Info;

public class UpdateRegistry {

	String[] urls = new String[]{
		"https://raw.githubusercontent.com/AwesomeSpider/Wizardry/master/src/main/resources/assets/wizardry/versionResources/CurrentVersion.txt",
		"https://raw.githubusercontent.com/AwesomeSpider/Wizardry/master/src/main/resources/assets/wizardry/versionResources/FeaturePhrase.txt",
		"https://raw.githubusercontent.com/AwesomeSpider/Wizardry/master/src/main/resources/assets/wizardry/versionResources/Changelog.txt"
	};
	
	public String version()
			throws IOException{
		String result;
		
		URL url = new URL(urls[0]);
		URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine);

        in.close();

        result = response.toString(); //Equals the version found (current).
        
        return result;
	}
	
	/**
	 * Performs an update check so the game knows if it
	 * needs to notify the player or not.
	 */
	public boolean performCheck(){
		boolean result = false;
		
		try {
			if (version() != null)
				result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String featurePhrase()
			throws IOException{
		String result;
		
		URL url = new URL(urls[1]);
		URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine);

        in.close();

        result = response.toString(); //Equals the version found (current).
        
        return result;
	}
	
	public String changelogLink(){
		return urls[2];
	}
}
