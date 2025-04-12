import java.util.ArrayList;

public class Animal {
    private String type;

    public void Animal(String type){
        this.type = type;
    }

    public void enterRoom(Veterinarian veterinarian, Animal animal){
        veterinarian.addAnimal(animal);
    }

}
