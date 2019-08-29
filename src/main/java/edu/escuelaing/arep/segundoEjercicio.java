package edu.escuelaing.arep;

import java.io.*;
import java.net.URL;

public class segundoEjercicio {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
		
		PrintWriter p = new PrintWriter(new FileWriter("resultado.html"));
		BufferedReader leeUrl = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Escriba la url");
		String urll = leeUrl.readLine();
		URL url = new URL(urll);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
			String inputLine = null;
			while ((inputLine = reader.readLine()) != null) {
				p.println(inputLine);
			}
		} catch (IOException x) {
			System.err.println(x);
		}

	}
}
