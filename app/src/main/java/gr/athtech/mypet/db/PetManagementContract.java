package gr.athtech.mypet.db;

import android.provider.BaseColumns;

/**
 * Created by xrist on 22/4/2017.
 */

public class PetManagementContract {

    private PetManagementContract() {
    }

    public static abstract class Pet implements BaseColumns {
        public static final String TABLE_NAME = "pets";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DATE_OF_BIRTH = "date_of_birth";
        public static final String COLUMN_NAME_GENDER = "gender";
        public static final String COLUMN_NAME_BREED = "breed";
        public static final String COLUMN_NAME_COLOR = "color";
        public static final String COLUMN_NAME_DISTINGUISHING_MARKS = "distinguishing_marks";
        public static final String COLUMN_NAME_CHIP_ID = "chip_id";
        public static final String COLUMN_NAME_SPECIES = "species";
        public static final String COLUMN_NAME_COMMENTS = "comments";
        public static final String COLUMN_NAME_IMAGE_URI = "imageUri";

        public static final String COLUMN_NAME_OWNER_FIRST_NAME = "owner_first_name";
        public static final String COLUMN_NAME_OWNER_LAST_NAME = "owner_last_name";
        public static final String COLUMN_NAME_OWNER_ADDRESS = "owner_address";
        public static final String COLUMN_NAME_OWNER_PHONE_NUMBER = "owner_phone_number";

        public static final String COLUMN_NAME_VET_FIRST_NAME = "vet_first_name";
        public static final String COLUMN_NAME_VET_LAST_NAME = "vet_last_name";
        public static final String COLUMN_NAME_VET_ADDRESS = "vet_address";
        public static final String COLUMN_NAME_VET_PHONE_NUMBER = "vet_phone_number";
    }
}
