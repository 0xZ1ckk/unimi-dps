import java.util.ArrayList;

public class Animal {
    private String type;

    public String getType(){
        return this.type;
    }

    public Animal(String type){
        this.type = type;
    }

    public void enterRoom(Veterinarian veterinarian, Animal animal) throws Exception{
        veterinarian.enterRoom(animal);
    }

}
