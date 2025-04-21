public class ServerWriterThread extends Thread {

    ChatRoom chatRoom;

    public ServerWriterThread(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public void run() {
        while (true) {
            try {
                chatRoom.processMessageQueue();
            } catch (Exception e) {
                System.out.println("Exception while processing message queue : " + e.getMessage());
            }
        }

    }

}
