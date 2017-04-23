package gr.athtech.mypet.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xrist on 18/3/2017.
 */

public class Owner extends Person {

    public Owner() {
    }

    public Owner(String firstName, String lastName, String address, String phoneNumber) {
        super(firstName, lastName, address, phoneNumber);
    }

    @Override
    public String getType() {
        return "owner";
    }

    protected Owner(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        address = in.readString();
        phoneNumber = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Owner createFromParcel(Parcel in) {
            return new Owner(in);
        }

        @Override
        public Owner[] newArray(int size) {
            return new Owner[size];
        }
    };
}
