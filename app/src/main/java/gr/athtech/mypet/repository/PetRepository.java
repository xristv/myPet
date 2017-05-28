package gr.athtech.mypet.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gr.athtech.mypet.db.PetManagementContract;
import gr.athtech.mypet.db.PetManagementDbHelper;
import gr.athtech.mypet.model.Owner;
import gr.athtech.mypet.model.Pet;
import gr.athtech.mypet.model.Vet;

/**
 * Handles the database queries
 * <p>
 * Created by xrist on 23/4/2017.
 */
public class PetRepository {

    private static final String[] PROJECTION = {
            PetManagementContract.Pet._ID,
            PetManagementContract.Pet.COLUMN_NAME_NAME,
            PetManagementContract.Pet.COLUMN_NAME_DATE_OF_BIRTH,
            PetManagementContract.Pet.COLUMN_NAME_GENDER,
            PetManagementContract.Pet.COLUMN_NAME_BREED,
            PetManagementContract.Pet.COLUMN_NAME_COLOR,
            PetManagementContract.Pet.COLUMN_NAME_DISTINGUISHING_MARKS,
            PetManagementContract.Pet.COLUMN_NAME_CHIP_ID,
            PetManagementContract.Pet.COLUMN_NAME_SPECIES,
            PetManagementContract.Pet.COLUMN_NAME_COMMENTS,
            PetManagementContract.Pet.COLUMN_NAME_IMAGE_URI,

            PetManagementContract.Pet.COLUMN_NAME_OWNER_FIRST_NAME,
            PetManagementContract.Pet.COLUMN_NAME_OWNER_LAST_NAME,
            PetManagementContract.Pet.COLUMN_NAME_OWNER_ADDRESS,
            PetManagementContract.Pet.COLUMN_NAME_OWNER_PHONE_NUMBER,

            PetManagementContract.Pet.COLUMN_NAME_VET_FIRST_NAME,
            PetManagementContract.Pet.COLUMN_NAME_VET_LAST_NAME,
            PetManagementContract.Pet.COLUMN_NAME_VET_ADDRESS,
            PetManagementContract.Pet.COLUMN_NAME_VET_PHONE_NUMBER,
    };

    // How you want the results sorted in the resulting Cursor
    private static final String SORT_ORDER = PetManagementContract.Pet.COLUMN_NAME_NAME + " ASC";

    private PetManagementDbHelper dbHelper;

    public PetRepository(Context context) {
        dbHelper = new PetManagementDbHelper(context);
    }

    public Long insertPet(Pet pet) {
        ContentValues values = new ContentValues();
        values.put(PetManagementContract.Pet.COLUMN_NAME_NAME, pet.getName());
        values.put(PetManagementContract.Pet.COLUMN_NAME_DATE_OF_BIRTH, pet.getDateOfBirth().getTime());
        values.put(PetManagementContract.Pet.COLUMN_NAME_GENDER, pet.getGender());
        values.put(PetManagementContract.Pet.COLUMN_NAME_BREED, pet.getBreed());
        values.put(PetManagementContract.Pet.COLUMN_NAME_COLOR, pet.getColor());
        values.put(PetManagementContract.Pet.COLUMN_NAME_DISTINGUISHING_MARKS, pet.getDistinguishingMarks());
        values.put(PetManagementContract.Pet.COLUMN_NAME_CHIP_ID, pet.getChipID());
        values.put(PetManagementContract.Pet.COLUMN_NAME_SPECIES, pet.getSpecies());
        values.put(PetManagementContract.Pet.COLUMN_NAME_COMMENTS, pet.getComments());
        values.put(PetManagementContract.Pet.COLUMN_NAME_IMAGE_URI, pet.getImageUri());

        values.put(PetManagementContract.Pet.COLUMN_NAME_OWNER_FIRST_NAME, pet.getOwner().getFirstName());
        values.put(PetManagementContract.Pet.COLUMN_NAME_OWNER_LAST_NAME, pet.getOwner().getLastName());
        values.put(PetManagementContract.Pet.COLUMN_NAME_OWNER_ADDRESS, pet.getOwner().getAddress());
        values.put(PetManagementContract.Pet.COLUMN_NAME_OWNER_PHONE_NUMBER, pet.getOwner().getPhoneNumber());

        values.put(PetManagementContract.Pet.COLUMN_NAME_VET_FIRST_NAME, pet.getVet().getFirstName());
        values.put(PetManagementContract.Pet.COLUMN_NAME_VET_LAST_NAME, pet.getVet().getLastName());
        values.put(PetManagementContract.Pet.COLUMN_NAME_VET_ADDRESS, pet.getVet().getAddress());
        values.put(PetManagementContract.Pet.COLUMN_NAME_VET_PHONE_NUMBER, pet.getVet().getPhoneNumber());

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        long newRowId;
        newRowId = db.insert(
                PetManagementContract.Pet.TABLE_NAME,
                null,
                values);

        return newRowId;
    }

    public List<Pet> getPets(String whereClause, String[] whereArgs) throws ParseException {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                PetManagementContract.Pet.TABLE_NAME,           // The table to query
                PROJECTION,                                     // The columns to return
                whereClause,                                    // The columns for the WHERE clause
                whereArgs,                                      // The values for the WHERE clause
                null,                                           // don't group the rows
                null,                                           // don't filter by row groups
                SORT_ORDER                                      // The sort order
        );

        List<Pet> pets = new ArrayList<>();

        int nameColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_NAME);
        int dateOfBirthColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_DATE_OF_BIRTH);
        int genderColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_GENDER);
        int breedColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_BREED);
        int colorColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_COLOR);
        int distinguishingMarksColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_DISTINGUISHING_MARKS);
        int chipIDColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_CHIP_ID);
        int speciesColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_SPECIES);
        int commentsColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_COMMENTS);
        int imageUriColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_IMAGE_URI);

        int ownerFirstNameColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_OWNER_FIRST_NAME);
        int ownerLastNameColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_OWNER_LAST_NAME);
        int ownerAddressColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_OWNER_ADDRESS);
        int ownerPhoneNumberColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_OWNER_PHONE_NUMBER);

        int vetFirstNameColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_VET_FIRST_NAME);
        int vetLastNameColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_VET_LAST_NAME);
        int vetAddressColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_VET_ADDRESS);
        int vetPhoneNumberColumn = cursor.getColumnIndexOrThrow(PetManagementContract.Pet.COLUMN_NAME_VET_PHONE_NUMBER);


        while (cursor.moveToNext()) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            String dob = format.format(new Date(cursor.getLong(dateOfBirthColumn)));
            Date dateOfBirth = format.parse(dob);

            Pet pet = new Pet(cursor.getString(nameColumn),
                    dateOfBirth,
                    cursor.getString(genderColumn),
                    cursor.getString(breedColumn),
                    cursor.getString(colorColumn),
                    cursor.getString(distinguishingMarksColumn),
                    cursor.getString(chipIDColumn),
                    cursor.getString(speciesColumn),
                    cursor.getString(commentsColumn),
                    cursor.getInt(imageUriColumn));

            Owner owner = new Owner(cursor.getString(ownerFirstNameColumn), cursor.getString(ownerLastNameColumn), cursor.getString(ownerAddressColumn), cursor.getString(ownerPhoneNumberColumn));
            Vet vet = new Vet(cursor.getString(vetFirstNameColumn), cursor.getString(vetLastNameColumn), cursor.getString(vetAddressColumn), cursor.getString(vetPhoneNumberColumn));

            pet.setOwner(owner);
            pet.setVet(vet);

            pets.add(pet);
        }

        cursor.close();

        return pets;
    }

    public List<Pet> getPets(String species) throws ParseException {
        String whereClause = PetManagementContract.Pet.COLUMN_NAME_SPECIES + "=?";
        String[] whereArgs = {species.toLowerCase()};

        return getPets(whereClause, whereArgs);
    }

    public void deletePet(String name) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.delete(PetManagementContract.Pet.TABLE_NAME, PetManagementContract.Pet.COLUMN_NAME_NAME + "='" + name+"'", null);
    }

    public int countPets() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String countQuery = "SELECT count(*) FROM " + PetManagementContract.Pet.TABLE_NAME;
        Cursor mcursor = db.rawQuery(countQuery, null);
        mcursor.moveToFirst();
        return mcursor.getInt(0);
    }

    public void initDb(List<Pet> pets) {
        if (countPets() == 0) {
            for (Pet pet : pets) {
                insertPet(pet);
            }
        }
    }
}
