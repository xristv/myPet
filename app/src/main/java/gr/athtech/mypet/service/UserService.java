package gr.athtech.mypet.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import gr.athtech.mypet.model.User;

/**
 * Created by xrist on 10/5/2017.
 * Heavily based on trumpets code.
 */

public class UserService extends IntentService {


    public static final String ACTION_CREATE_USER = "create_user";
    public static final String ACTION_GET_USERS = "get_user";
    public static final String ACTION_CREATE_STUDENTS_RESULT = "create_user_result";
    public static final String ACTION_GET_STUDENTS_RESULT = "get_user_result";

    private static final String GET_USER_URL = "http://hodor.ait.gr:8080/myPets/api/user/";
    private static final String CREATE_USER_URL = "http://hodor.ait.gr:8080/myPets/api/user/";


    public UserService() {
        super("User Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        if (ACTION_CREATE_USER.equals(action)) {
            createUser(intent);
        } else if (ACTION_GET_USERS.equals(action)) {
            getUser(intent);
        } else {
            throw new UnsupportedOperationException("No implementation for action " + action);
        }
    }

    private void createUser(Intent intent) {
        try {
            URL url = new URL(CREATE_USER_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.addRequestProperty("Content-Type", "application/json");

            String username = intent.getStringExtra("username");
            String password = intent.getStringExtra("password");
            String firstName = intent.getStringExtra("firstName");
            String lastName = intent.getStringExtra("lastName");

            User user = new User(username, password, firstName, lastName);

            String userJson = new Gson().toJson(user);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            writer.write(userJson);
            writer.flush();
            writer.close();

            conn.getOutputStream().close();
            conn.connect();

            int response = conn.getResponseCode();

          /*  Intent resultIntent = new Intent(ACTION_CREATE_STUDENT_RESULT);
            resultIntent.putExtra(EXTRA_CREATE_STUDENT_RESULT, "");
*/
        //    LocalBroadcastManager.getInstance(this).sendBroadcast(resultIntent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getUser(Intent intent) {
        InputStream is = null;

        try {
            URL url = new URL(GET_USER_URL + intent.getStringExtra("username") + "/" + intent.getStringExtra("password"));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);

            conn.connect();

            int response = conn.getResponseCode();
            is = conn.getInputStream();

            String result = convertStreamToString(is);

            Intent resultIntent = new Intent(ACTION_GET_STUDENTS_RESULT);
            resultIntent.putExtra("user", result);

            LocalBroadcastManager.getInstance(this).sendBroadcast(resultIntent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String convertStreamToString(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = is.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }

        return baos.toString();
    }
}
