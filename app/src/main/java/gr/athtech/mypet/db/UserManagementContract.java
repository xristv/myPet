package gr.athtech.mypet.db;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by xrist on 9/5/2017.
 */

public class UserManagementContract {

    public static final String AUTHORITY = "gr.athtech.mypet";

    // To prevent someone from accidentally instantiating the,
    // contract class, give it a private empty constructor.
    private UserManagementContract() {
    }

    // Inner class that defines the table contents
    // BaseColumns allow us to inherit a primary key field called _ID
    // that most Android classes expect
    public static abstract class User implements BaseColumns {

        public static final String TABLE_NAME = "student";
        public static final String COLUMN_NAME_USERNAME= "username";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_FIRST_NAME = "first_name";
        public static final String COLUMN_NAME_LAST_NAME = "last_name";

        public static final Uri CONTENT_URI = Uri.parse("content://" +
                AUTHORITY + "/" + TABLE_NAME);
    }

}
