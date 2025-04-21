import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ChatRoom chatRoom;

    public Server(){
        this.chatRoom = new ChatRoom();
    }

    public void execute() throws Exception{

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        ServerSocket mainSocket = new ServerSocket(4090);
        Socket clientSocket;
        ServerReaderThread serverReaderThread;
        ServerWriterThread serverWriterThread = new ServerWriterThread(chatRoom);
        serverWriterThread.start();

        System.out.println("Waiting for connections ...");

        while(true){
            clientSocket = mainSocket.accept();
            chatRoom.addSubscriber(clientSocket);
            serverReaderThread = new ServerReaderThread(clientSocket, chatRoom);
            serverReaderThread.start();
        }
    }

}
