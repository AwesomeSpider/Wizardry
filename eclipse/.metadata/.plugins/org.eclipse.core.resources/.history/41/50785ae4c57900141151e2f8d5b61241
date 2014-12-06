package com.awsp8.wizardry.registry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UpdateRegistry {

	/**
	 * Returns null if no new version is found. If null
	 * is returned, no further processing will be done in this
	 * class.
	 * @return New Version (if any)
	 * @throws IOException 
	 */
	public String newVersion()
			throws IOException{
		URL url = new URL("");
		URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine);

        in.close();

        return response.toString();
	}
}
