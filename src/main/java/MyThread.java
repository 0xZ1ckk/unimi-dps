import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyThread extends Thread {

    private Veterinarian veterinarian;
    private String catOrDog;

    public MyThread(Veterinarian veterinarian, String catOrDog) {
        this.catOrDog = catOrDog;
        this.veterinarian = veterinarian;
    }

    public void run() {
        try {
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            veterinarian.addAnimal(this.catOrDog);
        } catch (Exception e) {
            System.out.println("Error when adding animal");
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }
}
