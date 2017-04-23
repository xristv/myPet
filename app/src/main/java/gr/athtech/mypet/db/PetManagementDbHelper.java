package gr.athtech.mypet.db;

import android.content.Context;

/**
 * Created by xrist on 22/4/2017.
 */

public class PetManagementDbHelper extends BaseManagementDbHelper {

    protected static final String DATABASE_NAME = "PetManagement.db";

    protected static final String SQL_CREATE =
            "CREATE TABLE " + PetManagementContract.Pet.TABLE_NAME + " (" +
                    PetManagementContract.Pet._ID + INT_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    PetManagementContract.Pet.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_DATE_OF_BIRTH + INT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_GENDER + TEXT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_BREED + TEXT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_COLOR + TEXT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_DISTINGUISHING_MARKS + TEXT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_CHIP_ID + TEXT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_SPECIES + TEXT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_COMMENTS + TEXT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_IMAGE_URI + INT_TYPE + COMMA_SEP +

                    PetManagementContract.Pet.COLUMN_NAME_OWNER_FIRST_NAME + TEXT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_OWNER_LAST_NAME + TEXT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_OWNER_ADDRESS + TEXT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_OWNER_PHONE_NUMBER + TEXT_TYPE + COMMA_SEP +

                    PetManagementContract.Pet.COLUMN_NAME_VET_FIRST_NAME + TEXT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_VET_LAST_NAME + TEXT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_VET_ADDRESS + TEXT_TYPE + COMMA_SEP +
                    PetManagementContract.Pet.COLUMN_NAME_VET_PHONE_NUMBER + TEXT_TYPE +
                    " )";

    protected static final String SQL_DELETE =
            "DROP TABLE IF EXISTS " + PetManagementContract.Pet.TABLE_NAME;

    public PetManagementDbHelper(Context context) {
        super(context);
    }

}
