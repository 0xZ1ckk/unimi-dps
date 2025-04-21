import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientWriterThread extends Thread {

    private Socket connection;
    private BufferedReader inFromServer;

    public ClientWriterThread(Socket connection) throws IOException {
        this.connection = connection;
        inFromServer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    }

    public void run(){
        String message = null;
        while(true){
            try {
                message = inFromServer.readLine();
                System.out.println(message);
            } catch (IOException e) {
                System.out.println("Exception while reading input from or writing output to server : " + e.getMessage());
            }
        }
    }

}
