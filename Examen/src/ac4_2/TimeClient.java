package ac4_2;
import java.io.IOException;
import java.net.Socket;

public class TimeClient {

    private static final String SERVER_ADDR = "127.0.0.1";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) throws IOException {
        // Créer un socket TCP
        Socket socket = new Socket(SERVER_ADDR, SERVER_PORT);

        // Envoyer la requête au serveur
        String request = "get_time";
        socket.getOutputStream().write(request.getBytes());

        // Recevoir la réponse du serveur
        byte[] response = new byte[1024];
        int bytesRead = socket.getInputStream().read(response);

        // Afficher la réponse
        System.out.println(new String(response));

        // Fermer la connexion
        socket.close();
    }

}
