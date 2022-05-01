package com.example.myapplication1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication1.DbHelper;

public class SignupActivity extends Activity {

    EditText username1, email, setpassword, confirmpassword;
    Button register;
    DbHelper db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
        username1 = (EditText) findViewById(R.id.username1);
        email = (EditText) findViewById(R.id.EmailID);
        setpassword = (EditText) findViewById(R.id.SetPassword);
        confirmpassword = (EditText) findViewById(R.id.ConfirmPassword);
        register = (Button) findViewById(R.id.Register);
        db = new DbHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert all form data -firstname.gettext(),last....all
                if(db.insertData(username1.getText().toString(),setpassword.getText().toString(),email.getText().toString())){
                    System.out.println("inserted!!!!!!!!!!!");
                }else{
                    System.out.println("insert failed !!!!!!");
                }
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered(){
//        if (isEmpty(firstname)) {
//            Toast t = Toast.makeText(this , "You must enter first name to register", Toast.LENGTH_SHORT);
//            t.show();
//        }
//
//        if (isEmpty(lastname)) {
//            lastname.setError("Last name is required!");
//        }

        if (isEmail(email) == false){
            email.setError("Enter valid email!");
        }
    }

    //register - db insert
    //login - db user_name /email verify password if yes- home no - wrong password




    public void login_page(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}
