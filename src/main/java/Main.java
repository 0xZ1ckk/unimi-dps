import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws Exception {

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String userChoice;
        Server server;
        Client client;

        System.out.println("Server or client? (1/2) : ");
        userChoice = userInput.readLine();

        if (userChoice.equals("1")) {
           server = new Server();
           server.execute();
        } else if (userChoice.equals("2")){
            client = new Client();
            client.execute();
        }
    }

}
