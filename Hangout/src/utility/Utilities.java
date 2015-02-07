package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import database.DocumentHandle;

public class Utilities {

	public static DocumentHandle getDocument(String idURI, String revURI, String username) {
		return new DocumentHandle(
				getResponseFromRequest(idURI),
				getResponseFromRequest(revURI));
	}
	
	public static String getResponseFromRequest(String uri) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(uri);
		try {
			BufferedReader reader = (new BufferedReader(new InputStreamReader(client.execute(get).getEntity().getContent())));
			String message = "";
			String line = reader.readLine();
			while (line != null) {
				message += line;
				line = reader.readLine();
			}
			return message;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public static List<String> csvToList(String csv) {
		return Arrays.asList(csv.split(","));
	}
	
	public static String getStringFromView(String urlString) {
		URL url;
		String realLine = null;
		try {
			url = new URL(urlString);
			URLConnection conn = url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(false);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));

			// reads from file or url
			String line = null;
			while ((line = reader.readLine()) != null) {
				realLine = line.replaceAll("&#39;", "'");
				realLine = realLine.replaceAll("%27;", "'");
				realLine = realLine.replace("<br>", "");
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return realLine;
	}
			
}
