package com.example.smartbustrackingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText studentname,studentparentname,mobilenumber,studentaddress;
Button save;
FirebaseDatabase rootnode;
DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        save=findViewById(R.id.submit);
        studentname=findViewById(R.id.name);
        studentparentname=findViewById(R.id.parentname);
        mobilenumber=findViewById(R.id.parentnumber);
        studentaddress=findViewById(R.id.address);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(getApplicationContext(),
                        LoginActivity.class);

                startActivity(i1);
                rootnode=FirebaseDatabase.getInstance();
                reference=rootnode.getReference("users");
                reference.setValue("Firebase");
                String name=studentname.getEditableText().toString();
                String parentname=studentparentname.getEditableText().toString();
                String number=mobilenumber.getEditableText().toString();
                String address=studentaddress.getEditableText().toString();
                UserHelper userHelper=new UserHelper(name,parentname,number,address);
                reference.child(number).setValue(userHelper);


            }
        });

    }
}