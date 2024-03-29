package edu.escuelaing.arep;

import java.net.*;
import java.io.*;

public class ejercicioCuatroTresUnoServidor {
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(35002);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 35002.");
			System.exit(1);
		}
		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String inputLine;
		String outputLine;
		double inputLine2;
		while ((inputLine = in.readLine()) != null) {
			System.out.println("Mensaje:" + inputLine);
			inputLine2 = Double.parseDouble(inputLine);
			outputLine = "Respuesta " + Math.pow(inputLine2, 2);
			out.println(outputLine);
			if (outputLine.equals("Respuestas: Bye."))
				break;
		}
		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}


}
