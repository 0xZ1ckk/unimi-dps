import java.util.ArrayList;

public class Veterinarian {

	private ArrayList<Animal> room;
	private int roomCapacity;

	public void VeterinarianRoom(int roomCapacity){
		this.roomCapacity = roomCapacity;
	}

	public void addAnimal(Animal animal){
		if(this.roomCapacity < room.size()){
			this.room.add(animal);
		} else {
			System.out.println("Room is full"); }

	}
}