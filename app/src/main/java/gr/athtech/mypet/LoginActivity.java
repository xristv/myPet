package gr.athtech.mypet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import gr.athtech.mypet.model.User;
import gr.athtech.mypet.service.UserService;

/**
 * Created by xrist on 9/5/2017.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setListeners();
    }

    /**
     * Setup the various activity listeners
     */
    private void setListeners() {
        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                login();
            }
        });

        TextView registerTextView = (TextView) findViewById(R.id.registerTextView);
        registerTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login() {
        Intent intent = new Intent(this, UserService.class);
        intent.setAction(UserService.ACTION_GET_USERS);
        intent.putExtra("username", ((EditText) findViewById(R.id.usernameText)).getText().toString());
        intent.putExtra("password", ((EditText) findViewById(R.id.passwordText)).getText().toString());
        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter getUserResultIntentFilter = new IntentFilter(UserService.ACTION_CREATE_USER_RESULT);
        broadcastManager.registerReceiver(getUserBroadcastReceiver, getUserResultIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
        broadcastManager.unregisterReceiver(getUserBroadcastReceiver);
    }

    private BroadcastReceiver getUserBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            afterLogin(intent.getStringExtra("userResult"));
        }
    };

    private void afterLogin(String userResult) {
        if (!userResult.isEmpty()) {
            User user = new Gson().fromJson(userResult, User.class);
            SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", user.getUsername());
            editor.apply();
        } else {
            Toast.makeText(this, "Username and password are not correct!", Toast.LENGTH_LONG).show();
        }

    }
}
