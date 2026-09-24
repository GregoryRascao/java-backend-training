package projects.project1;
import java.util.List;
import java.util.ArrayList;

public class ZooManagment {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        animals.add(new Lion("simba"));
        animals.add(new Monkey("george"));
        animals.add(new Penguin("kipper"));

        System.out.println("List of animals");
        listAnimal(animals);

        System.out.println("\nChorus sound for animals :");
        chorusSound(animals);
        
        
        System.out.println("\nlet's feeds the animals :");
        feedingAnimals(animals);
    }

    public static void listAnimal(List<Animal> animals){
        for(Animal animal: animals){
            System.out.println("- " + animal);
        }
    }

    public static void chorusSound(List<Animal> animals){
        for(Animal animal: animals){
            animal.makeSound();
        }
    }

    public static void feedingAnimals(List<Animal> animals){
        for (Animal animal : animals) {
            animal.feed();
        }
    }

}
