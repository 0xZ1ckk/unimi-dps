import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReaderThread extends Thread {

    private Socket clientSocket;
    private ChatRoom chatRoom;
    private BufferedReader clientInput;

    public ServerReaderThread(Socket connectionSocket, ChatRoom chatRoom) throws IOException {
        this.clientSocket = connectionSocket;
        this.chatRoom = chatRoom;
        this.clientInput = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
    }

    public void run() {

        String clientMessage = null;

        System.out.println("New client from port " + this.clientSocket.getPort() + " connected!");

        while (true) {
            try {
                clientMessage = clientInput.readLine();
            } catch (IOException e) {
                System.out.println("Exception while reading user input : " + e.getMessage());
            }
            chatRoom.addMessage(clientMessage);
        }
    }
}
