import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public void execute() throws IOException {

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String port, message;
        DataOutputStream outToServer;
        BufferedReader inFromServer;

        System.out.println("Insert port server port to connect to : ");
        port = userInput.readLine();

        Socket connection = new Socket("127.0.0.1", Integer.parseInt(port));
        ClientWriterThread clientWriterThread = new ClientWriterThread(connection);
        clientWriterThread.start();
        outToServer = new DataOutputStream(connection.getOutputStream());
        System.out.print("Start texting : ");

        while(true){
            message = userInput.readLine();
            outToServer.writeBytes(message + "\n");
        }
    }
}
