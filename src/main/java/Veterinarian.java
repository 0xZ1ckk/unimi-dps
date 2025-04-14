import java.io.BufferedReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class Veterinarian {

    public int catsCounter = 0;
    public int dogsCounter = 0;
    public int catsWaiting = 0;
    public int dogsWaiting = 0;

    public synchronized void enterRoom(Animal animal) throws Exception {
        if (animal.getType().equals(("cat"))) {
            catsCounter++;
        } else if (animal.getType().equals("dog")) {
            dogsCounter++;
        }
    }

    public synchronized void exitRoom(Animal animal) throws Exception {
        if (animal.getType().equals(("cat"))) {
            catsCounter--;
        } else if (animal.getType().equals("dog")) {
            dogsCounter--;
        }
    }

    public void addAnimal(BufferedReader userInput) throws Exception {
        System.out.print("Do you wanna add a cat or a dog? C/D : ");
        String catOrDog = userInput.readLine();

        if (catOrDog.equals("cat")) {
            if (catsCounter != 0 || dogsCounter != 0) {
                wait();
                catsWaiting++;
            } else {
                enterRoom(new Animal(catOrDog));
                catsCounter++;
            }
        } else if (catOrDog.equals("dog")) {
            if (catsCounter != 0 || dogsCounter > 3) {
                wait();
                dogsWaiting++;
            }
        } else {
            enterRoom(new Animal(catOrDog));
            dogsCounter++;
        }
    }


    public void removeAnimal(BufferedReader userInput) throws Exception {
        System.out.print("Do you wanna remove a cat or a dog? C/D : ");
        String catOrDog = userInput.readLine();

        if (catOrDog.equals("cat")) {
            if (catsCounter > 0) {
                catsCounter--;
                notify();
            } else {
                System.out.println("There's no cats!");
            }
        } else if (catOrDog.equals("dog")) {
            if (dogsCounter > 0) {
                dogsWaiting--;
                notify();
            } else {
                System.out.print("There's no dogs!");
            }
        } else {
            enterRoom(new Animal(catOrDog));
            dogsCounter++;
        }
    }
}