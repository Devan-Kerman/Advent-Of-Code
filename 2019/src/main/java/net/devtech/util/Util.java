package net.devtech.util;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

public class Util {
	public static Stream<String> getData(String resource) {
		return new BufferedReader(new InputStreamReader(Util.class.getResourceAsStream(resource))).lines();
	}

	public static Stream<String> getURL(String url) {
		try {
			HttpsURLConnection connection = (HttpsURLConnection) new java.net.URL(url).openConnection();
			connection.addRequestProperty("cookie", "session=" + getSession());
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			return reader.lines();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static String getSession() {
		InputStream stream = Util.class.getResourceAsStream("/session.pass");
		if(stream == null)
			throw new RuntimeException("No file with name session.pass was found in resources");
		return new Scanner(new InputStreamReader(stream)).nextLine();
	}

	public static void submit(String url, String answer) throws IOException {
		HttpsURLConnection connection = (HttpsURLConnection) new java.net.URL(url).openConnection();
		connection.addRequestProperty("cookie", "session="+getSession());
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		byte[] packet = ("answer="+answer+"&level=1").getBytes(); // TODO verify level is always one
		connection.setFixedLengthStreamingMode(packet.length);
		connection.getOutputStream().write(packet);
	}
}
