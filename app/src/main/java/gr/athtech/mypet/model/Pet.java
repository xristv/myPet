package gr.athtech.mypet.model;

/**
 * The Pet class holds all the basic information about... a pet
 *
 * Created by xrist on 9/3/2017.
 */

public class Pet {

    private String name;
    private String breed;
    private int age;

    public Pet(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
