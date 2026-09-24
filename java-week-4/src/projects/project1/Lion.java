package projects.project1;

class Lion extends Animal {

    public Lion(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " roar: Graouuuuuu");
    }

    @Override 
    public void feed(){
        System.out.println("Feeding " + getName() + " with a steak");
    }
}