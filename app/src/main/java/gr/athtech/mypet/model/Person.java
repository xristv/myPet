package gr.athtech.mypet.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xrist on 18/3/2017.
 */

public class Person implements Parcelable {

    protected String firstName;
    protected String lastName;
    protected String address;
    protected String phoneNumber;
    protected String type;

    public Person() {
    }

    public Person(String firstName, String lastName, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.type=this.getType();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Tel: " + phoneNumber + ", Addr: " + address;
    }

    protected Person(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        address = in.readString();
        phoneNumber = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(address);
        dest.writeString(phoneNumber);
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
