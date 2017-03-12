package gr.athtech.mypet.model;

/**
 * The Pet class holds all the basic information about... a pet
 * <p>
 * Created by xrist on 9/3/2017.
 */

public class Pet {

    private String name;
    private String breed;
    private int age;
    private int image;

    public Pet(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public Pet(String name, String breed, int age, int image) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.image = image;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
