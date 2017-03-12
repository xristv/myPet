package gr.athtech.mypet.model;

/**
 * Created by xrist on 9/3/2017.
 */

public class Dog extends Pet {

    public Dog(String name, String breed, int age) {
        super(name, breed, age);
    }

    public Dog(String name, String breed, int age, int image) {
        super(name, breed, age, image);
    }

    public String bark() {
        return "Woof";
    }
}
