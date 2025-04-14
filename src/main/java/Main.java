import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        Veterinarian veterinarian = new Veterinarian();
        String addAnimal, removeAnimal, roomStats, catOrDog;
        MyThread myThread;

        while (true) {
            try {

                roomStats = "\nRoom stats : \nDogs in the room : " + veterinarian.dogsCounter
                        + "\nCats in the room : " + veterinarian.catsCounter
                        + "\nDogs waiting : " + veterinarian.dogsWaiting
                        + "\nCats waiting : " + veterinarian.catsWaiting;
                System.out.println(roomStats);

                System.out.print("\nDo you wanna add an animal? Y/N : ");
                addAnimal = userInput.readLine();

                if (addAnimal.equals("Y")) {
                    System.out.print("\nDo you wanna add a cat or a dog? C/D : ");
                    catOrDog = userInput.readLine();

                    myThread = new MyThread(veterinarian, catOrDog);
                    myThread.start();
                }

                System.out.println("Do you wanna remove an animal? Y/N : ");
                removeAnimal = userInput.readLine();

                if(removeAnimal.equals("Y")){
                    System.out.println("Do you wanna remove a cat or a dog? C/D : ");
                    catOrDog = userInput.readLine();
                    veterinarian.removeAnimal(catOrDog);
                }

            } catch (Exception e) {
                System.out.println("Exception either while reading input or entering room" + e.getMessage());
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
