package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ejercicioCuatroTresDosServidor {
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(35000);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 35000.");
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
		String outputLine = null;
		double inputLine2 = 0;
		String partir;
		String operacion= "cos";
		while ((inputLine = in.readLine()) != null) {
			System.out.println("Mensaje:" + inputLine);
			if(!inputLine.contains("fun:")) {
				inputLine2 = Double.parseDouble(inputLine);
				if(operacion.equals("cos")) {
					outputLine = "El coseno es " + Math.cos(inputLine2);
				}else if(operacion.equals("sin")) {
					outputLine = "El seno es " + Math.sin(inputLine2);
				}else {
					outputLine = "La tangente es" + Math.tan(inputLine2);
				}
				
			}else {
				partir = inputLine.split(":")[1];
				if(partir.contains("sin")) {
					operacion = "sin";
					outputLine = "El seno es " + Math.sin(inputLine2);
				}else if(partir.contains("tan")) {
					operacion = "tan";
					outputLine = "La tangente es " + Math.tan(inputLine2);
				}else if(partir.contains("cos")) {
					operacion = "cos";
					outputLine = "El coseno es " + Math.cos(inputLine2);
				}else {
					outputLine = "No es válido.";
				}
			}
			
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
