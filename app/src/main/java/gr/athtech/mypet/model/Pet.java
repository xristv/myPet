package gr.athtech.mypet.model;

import java.util.Date;

/**
 * The Pet class holds all the basic information about... a pet
 * <p>
 * Created by xrist on 9/3/2017.
 */

public class Pet {

    private String name;
    private Date dateOfBirth;
    private String sex;
    private String breed;
    private String color;
    private String distinguishingMarks;
    private String petigree;
    private int image;
    private Owner owner;
    private Vet vet;

    public Pet() {
    }

    public Pet(String name, String breed, int image) {
        this.name = name;
        this.breed = breed;
        this.image = image;
    }

    public Pet(String name, Date dateOfBirth, String sex, String breed, String color, String distinguishingMarks, String petigree, int image, Owner owner, Vet vet) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.breed = breed;
        this.color = color;
        this.distinguishingMarks = distinguishingMarks;
        this.petigree = petigree;
        this.image = image;
        this.owner = owner;
        this.vet = vet;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDistinguishingMarks() {
        return distinguishingMarks;
    }

    public void setDistinguishingMarks(String distinguishingMarks) {
        this.distinguishingMarks = distinguishingMarks;
    }

    public String getPetigree() {
        return petigree;
    }

    public void setPetigree(String petigree) {
        this.petigree = petigree;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}
