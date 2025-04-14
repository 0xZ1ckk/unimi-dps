import java.io.BufferedReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class Veterinarian {

    public int catsCounter = 0;
    public int dogsCounter = 0;
    public int catsWaiting = 0;
    public int dogsWaiting = 0;

    public synchronized void addAnimal(String catOrDog) throws Exception {
        if (catOrDog.equals("C")) {
            while (this.catsCounter != 0 || this.dogsCounter != 0) {
                this.catsWaiting++;
                System.out.println("\nCat is now waiting");
                wait();
                this.catsWaiting--;
            }
            this.catsCounter++;
            System.out.println("\nCat has entered the room");
        } else if (catOrDog.equals("D")) {
            while (this.catsCounter != 0 || this.dogsCounter > 3) {
                this.dogsWaiting++;
                System.out.println("\nDog is now waiting");
                wait();
                this.dogsWaiting--;
            }
            this.dogsCounter++;
            System.out.println("\nDog has entered the room");
        }
    }

    public synchronized void removeAnimal(String catOrDog) throws Exception {
        if (catOrDog.equals("C")) {
            catsCounter--;
            System.out.println("A cat has been removed");
        } else if (catOrDog.equals("D")) {
            dogsCounter--;
            System.out.println("A dog has been removed");
        }
        notify();
    }
}