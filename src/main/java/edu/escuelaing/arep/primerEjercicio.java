package edu.escuelaing.arep;

import java.net.MalformedURLException;
import java.net.URL;

public class primerEjercicio {
	
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("https://www.google.com.co:80/search?q=estructura+de+una+url&rlz=1C1SQJL_enCO863CO863&oq=estructura+de+una+url&aqs=chrome..69i57j0l5.5255j0j7&sourceid=chrome&ie=UTF-8#notnull");
		
		System.out.println("Authority:" + url.getAuthority());
		System.out.println("Host:" + url.getHost());
		System.out.println("Protocol:" + url.getProtocol());
		System.out.println("Port:" + url.getPort());
		System.out.println("Path:" + url.getPath());
		System.out.println("Query:" + url.getQuery());
		System.out.println("File:" + url.getFile());
		System.out.println("Ref:" + url.getRef());
	}


}
