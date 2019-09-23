package com.example.assignment1calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.FocusFinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button add,mul,sub,divide,sc,history;
    private TextView res;
    private EditText num1,num2;
    FirebaseDatabase database;
    DatabaseReference myRef;
    float s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        history=findViewById(R.id.history);
        add=findViewById(R.id.add_btn);
        sub=findViewById(R.id.sub_btn);
        mul=findViewById(R.id.mul_btn);
        divide=findViewById(R.id.divide_btn);
        sc= findViewById(R.id.sc_btn);
        res= findViewById(R.id.res_tv);
        num1=findViewById(R.id.num1_et);
        num2=findViewById(R.id.num2_et);

        add.setOnClickListener(this);
        mul.setOnClickListener(this);
        divide.setOnClickListener(this);
        sub.setOnClickListener(this);
        sc.setOnClickListener(this);
        history.setOnClickListener(this);

         database = FirebaseDatabase.getInstance();
         myRef = database.getReference();




    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.add_btn)
        {
            String c1=num1.getText().toString();
            String c2=num2.getText().toString();
            if(c1.isEmpty())
            {
                Toast.makeText(this,"Enter 1st Number",Toast.LENGTH_SHORT).show();

            }
            else  if(c2.isEmpty())
            {
                Toast.makeText(this,"Enter 2nd Number",Toast.LENGTH_SHORT).show();

            }
            else
            {
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                s=n1+n2;
                res.setText(String.valueOf(s));
                myRef.child(c1+" + "+c2).setValue(" = "+String.valueOf(s));
            }




        }
        else  if(v.getId()==R.id.mul_btn)
        {
            String c1=num1.getText().toString();
            String c2=num2.getText().toString();
            if(c1.isEmpty())
            {
                Toast.makeText(this,"Enter 1st Number",Toast.LENGTH_SHORT).show();

            }
            else  if(c2.isEmpty())
            {
                Toast.makeText(this,"Enter 2nd Number",Toast.LENGTH_SHORT).show();

            }
            else
            {
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                float s=(float) n1*n2;
                res.setText(String.valueOf(s));
                myRef.child(c1+" * "+c2).setValue(" = "+String.valueOf(s));

            }

        }
        else  if(v.getId()==R.id.divide_btn)
        {
            String c1=num1.getText().toString();
            String c2=num2.getText().toString();
            if(c1.isEmpty())
            {
                Toast.makeText(this,"Enter 1st Number",Toast.LENGTH_SHORT).show();

            }
            else  if(c2.isEmpty())
            {
                Toast.makeText(this,"Enter 2nd Number",Toast.LENGTH_SHORT).show();

            }
            else
            {
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                float s=(float) n1/n2;
                res.setText(String.valueOf(s));
                myRef.child(c1+" divide "+c2).setValue(" = "+String.valueOf(s));
            }

        }
        else  if(v.getId()==R.id.sub_btn)
        {
            String c1=num1.getText().toString();
            String c2=num2.getText().toString();
            if(c1.isEmpty())
            {

                Toast.makeText(this,"Enter 1st Number",Toast.LENGTH_SHORT).show();

            }
            else  if(c2.isEmpty())
            {
                Toast.makeText(this,"Enter 2nd Number",Toast.LENGTH_SHORT).show();

            }
            else
            {
                int n1=Integer.parseInt(num1.getText().toString());
                int n2=Integer.parseInt(num2.getText().toString());
                int s=n1-n2;
                res.setText(String.valueOf(s));
                myRef.child(c1+" - "+c2).setValue(" = "+String.valueOf(s));
            }

        }
        else  if(v.getId()==R.id.history)
        {
            Intent intent=new Intent(MainActivity.this,history.class);
            startActivity(intent);




        }
        else
        {
            Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show();
           Intent intent=new Intent(MainActivity.this,part2.class);
           startActivity(intent);


        }

    }

}
