package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import database.DocumentHandle;

public class Utilities {

	public DocumentHandle getDocument(String idURI, String revURI, String username) {
		return new DocumentHandle(
				getResponseFromRequest(idURI),
				getResponseFromRequest(revURI));
	}
	
	public String getResponseFromRequest(String uri) {
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
	
	public List<String> csvToList(String csv) {
		return Arrays.asList(csv.split(","));
	}
}
