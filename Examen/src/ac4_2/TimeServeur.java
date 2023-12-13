package ac4_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
  public class TimeServeur {
	 private static final int PORT = 1234;
	    public static void main(String[] args) throws IOException {
	        ServerSocket serverSocket = new ServerSocket(PORT);
	        System.out.println("Le serveur attend la connexion d'un client");
	        while (true) {
	            // Attendre une connexion entrante
	            Socket socket = serverSocket.accept();
	               // Lire la demande du client
	            InputStream inputStream = socket.getInputStream();
	            byte[] request = new byte[1024];
	            int bytesRead = inputStream.read(request);

	            // Renvoyer la date et l'heure actuelles
	            LocalDateTime now = LocalDateTime.now();
	            String response = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

	            // Envoyer la réponse au client
	            OutputStream outputStream = socket.getOutputStream();
	            outputStream.write(response.getBytes());

	            // Fermer la connexion
	            socket.close(); }    }}
