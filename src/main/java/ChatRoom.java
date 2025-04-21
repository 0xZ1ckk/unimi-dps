import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ChatRoom {

    private ArrayList<Socket> subscribers;
    private ArrayList<String> messageQueue;
    private DataOutputStream outToClient;
    private int buffer;

    public ChatRoom() {
        this.subscribers = new ArrayList<Socket>();
        this.messageQueue = new ArrayList<String>();
    }

    public void addSubscriber(Socket clientSocket) {
        this.subscribers.add(clientSocket);
    }

    public synchronized void addMessage(String message) {
        this.messageQueue.add(message);
        //this.buffer++;
        System.out.println("Buffer simulator value : " + this.buffer);
        //if (this.buffer >= 5) {
            //this.buffer = 0;
            notify();
        //}
    }

    public synchronized void processMessageQueue() throws InterruptedException, IOException {
        if (!messageQueue.isEmpty()) {
            System.out.println("Sending all messages in the queue to clients ...");
            for (Socket socket : subscribers) {
                this.outToClient = new DataOutputStream(socket.getOutputStream());
                for (String message : this.messageQueue) {
                    outToClient.writeBytes(message + "\n");
                }
            }
        }
        this.messageQueue.clear();
        wait();
    }

}
