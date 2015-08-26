package com.muscleup.luticussoftwareinc.muscleup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button newUserButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createItem();//create all button and edittext
        addListenerOnButtonClick();
    }

    public void addListenerOnButtonClick(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEditText();

            }
        });
        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open activitey addnewusers if user click new user button
                startActivity(new Intent(getApplicationContext(), AddNewUsers.class));
            }
        });
    }
    //check if user name and password are not null
    public boolean checkEditText(){
        if(usernameEditText.getText().toString().trim().length()<=0) {
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_LONG).show();
            return false;
        }
        if(passwordEditText.getText().toString().trim().length()<=0) {
            Toast.makeText(this, "You did not enter a password", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    //create all button and edittext and etc.
    public void createItem(){
        usernameEditText=(EditText)findViewById(R.id.editTextUserName);
        passwordEditText=(EditText)findViewById(R.id.editTextPassword);
        loginButton=(Button)findViewById(R.id.buttonLogin);
        newUserButton=(Button)findViewById(R.id.buttonNewUser);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
