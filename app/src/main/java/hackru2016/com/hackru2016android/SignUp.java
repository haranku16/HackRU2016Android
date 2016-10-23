package hackru2016.com.hackru2016android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;

import pojos.SignUpPojo;

public class SignUp extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText username;
    EditText password;
    EditText confpass;
    EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signupButton();
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.pass);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        confpass = (EditText) findViewById(R.id.confpass);


    }


    //After the user fills out fields, if he/she clicks "Sign Up," a toast shows up that a text message will be sent
    // then it redirects to TextConfirm.java
    public void signupButton() {
        Button signupbutton = (Button) findViewById(R.id.signupButton);
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username == null || password == null || confpass == null){
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Username or Password or Confirm Password are empty", Toast.LENGTH_LONG);
                }

                if (!confpass.toString().equals(password.getText().toString())) {
                    Context context1 = getApplicationContext();
                    CharSequence text1 = "Error: Passwords do not match";
                    int duration1 = Toast.LENGTH_LONG;
                    Toast toast1 = Toast.makeText(context1, text1, duration1);
                    toast1.show();
                } else {
                    SignUpPojo signuppojo = new SignUpPojo(firstName.getText().toString(), lastName.getText().toString(), username.getText().toString(), password.getText().toString(), phoneNumber.getText().toString());
                    ObjectMapper om = new ObjectMapper();
                    try {
                        String body = om.writeValueAsString(signuppojo);
                        try {
                            URL url = new URL("http://vamshikrishnansair.home:3000/REST/signup");
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
                            dos.write(body.getBytes("UTF-8"));
                            int responseCode = connection.getResponseCode();
                            if (responseCode != 404) {
                                Intent intent = new Intent(SignUp.this, TextConfirm.class);
                                intent.putExtra("signuppojo",signuppojo);
                                Context context2 = getApplicationContext();
                                CharSequence text2 = " You will be be sent a text message shortly!";
                                int duration2 = Toast.LENGTH_LONG;
                                Toast toast2 = Toast.makeText(context2, text2, duration2);
                                toast2.show();
                                startActivity(intent);
                            } else {
                                Toast toast2 = Toast.makeText(getApplicationContext(),"Trouble connecting to server.",Toast.LENGTH_LONG);
                            }
                        } catch (IOException e ) {
                            // DO NOTHING
                        }
                    } catch (JsonProcessingException e) {
                        Toast toast1 = Toast.makeText(getApplicationContext(),"OH NOOOOOOOO",Toast.LENGTH_LONG);
                    }
                }
            }
        });
    }
}

