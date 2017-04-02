package gr.athtech.mypet.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xrist on 18/3/2017.
 */

public class Vet extends Person {

    public Vet() {
    }

    public Vet(String firstName, String lastName, String address, String phoneNumber) {
        super(firstName, lastName, address, phoneNumber);
    }

    protected Vet(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        address = in.readString();
        phoneNumber = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Vet createFromParcel(Parcel in) {
            return new Vet(in);
        }

        @Override
        public Vet[] newArray(int size) {
            return new Vet[size];
        }
    };
}
