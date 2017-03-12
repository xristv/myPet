package gr.athtech.mypet.model;

/**
 * Created by xrist on 9/3/2017.
 */

public class Cat extends Pet {

    public Cat(String name, String breed, int age) {
        super(name, breed, age);
    }

    public Cat(String name, String breed, int age, int image) {
        super(name, breed, age, image);
    }

    public String purr() {
        return "Purr";
    }
}