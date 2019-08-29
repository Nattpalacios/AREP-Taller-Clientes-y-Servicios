package edu.escuelaing.arep;

import java.io.*;
import java.net.*;

public class ejercicioCuatroTresUnoCliente {
	
	public static void main(String[] args) throws IOException {
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			echoSocket = new Socket("127.0.0.1", 35002);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don’t know about host!.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn’t get I/O for " + "the connection to: localhost.");
			System.exit(1);
		}
		double num;
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		while ((userInput = stdIn.readLine()) != null) {
			num = Double.parseDouble(userInput);
			out.println(num);
			System.out.println(in.readLine());
		}
		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	}
}
