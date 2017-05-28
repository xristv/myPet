package gr.athtech.mypet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by xrist on 9/5/2017.
 */

public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setListeners();
    }

    /**
     * Setup the various activity listeners
     */
    private void setListeners() {
        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
               // intent.setAction(UserService.ACTION_CREATE_USER);
                intent.putExtra("username", ((EditText) findViewById(R.id.usernameText)).getText());
                intent.putExtra("password", ((EditText) findViewById(R.id.passwordText)).getText());
                intent.putExtra("firstName", ((EditText) findViewById(R.id.firstNameText)).getText());
                intent.putExtra("lastName", ((EditText) findViewById(R.id.lastNameText)).getText());
                startService(intent);
            }
        });
    }
}
