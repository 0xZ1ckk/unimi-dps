import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main() {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        Veterinarian veterinarian = new Veterinarian();
        String addAnimal, removeAnimal, roomStats;

        roomStats = "Room stats : \nDogs in the room : " + veterinarian.dogsCounter
                + "\nCats in the room : " + veterinarian.catsCounter
                + "\nDogs waiting : " + veterinarian.dogsWaiting
                + "\nCats waiting : " + veterinarian.catsWaiting;

        while (true) {
            try {

                System.out.println(roomStats);

                System.out.print("Do you wanna add an animal? Y/N : ");
                addAnimal = userInput.readLine();

                if (addAnimal.equals("Y")) {
                    veterinarian.addAnimal(userInput);
                }

                System.out.print("Do you wanna remove an animal? Y/N");
                removeAnimal = userInput.readLine();

                if (removeAnimal.equals("Y")) {
                    veterinarian.removeAnimal(userInput);
                }

            } catch (Exception e) {
                System.out.println("Exception either while reading input or entering room");
                System.exit(1);
            }
        }
    }
}
/* if (animal.getType().equals(("cat"))) {
        if (catsCounter > 0 || dogsCounter > 0) {
            wait();
        } else {
            catsCounter++;
        }
    } else if (animal.getType().equals("dog")) {
        if (dogsCounter > 4) {
            wait();
        } else if (catsCounter > 0) {
            wait();
        } else {
            dogsCounter++;
        }
    }
}*/
