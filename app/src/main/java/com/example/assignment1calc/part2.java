package com.example.assignment1calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.tan;

public class part2 extends AppCompatActivity implements View.OnClickListener {

    private Button sin,cos,tan,root,power;
    private EditText num3,num4;
    private TextView res2;
    private ImageView img;
    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);
        sin=findViewById(R.id.sin_btn);
        cos=findViewById(R.id.cos_btn);
        tan=findViewById(R.id.tan_btn);
        root=findViewById(R.id.root_btn);
        power=findViewById(R.id.power_btn);
        num3=findViewById(R.id.num3_et);
        num4=findViewById(R.id.num4_et);
        res2=findViewById(R.id.res2_tv);
        img=findViewById(R.id.img_v);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        root.setOnClickListener(this);
        power.setOnClickListener(this);
        img.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.sin_btn)
        {
            String c1=num3.getText().toString();
            if(c1.isEmpty())
            {
                Toast.makeText(this,"Enter a number",Toast.LENGTH_SHORT).show();

            }
            else
            {
                int n=Integer.parseInt(num3.getText().toString());
                double s=sin(n);
                res2.setText(String.valueOf(s));
                myRef.child("sin("+n+")").setValue(" = "+String.valueOf(s));
            }



        }
        else  if(v.getId()==R.id.cos_btn)
        {
            String c1=num3.getText().toString();
            if(c1.isEmpty())
            {
                Toast.makeText(this,"Enter a number",Toast.LENGTH_SHORT).show();

            }
            else
            {
                int n=Integer.parseInt(num3.getText().toString());
                double s=cos(n);
                res2.setText(String.valueOf(s));
                myRef.child("cos("+n+")").setValue(" = "+String.valueOf(s));
            }

        }
        else  if(v.getId()==R.id.tan_btn)
        {
            String c1=num3.getText().toString();
            if(c1.isEmpty())
            {
                Toast.makeText(this,"Enter a number",Toast.LENGTH_SHORT).show();

            }
            else
            {
                int n=Integer.parseInt(num3.getText().toString());
                double s=tan(n);
                res2.setText(String.valueOf(s));
                myRef.child("tan("+n+")").setValue(" = "+String.valueOf(s));
            }

        }
        else  if(v.getId()==R.id.root_btn)
        {
            String c1=num3.getText().toString();
            if(c1.isEmpty())
            {
                Toast.makeText(this,"Enter a number",Toast.LENGTH_SHORT).show();

            }
            else
            {
                int n=Integer.parseInt(num3.getText().toString());
                double s=sqrt(n);
                res2.setText(String.valueOf(s));
                myRef.child("root("+n+")").setValue(" = "+String.valueOf(s));
            }

        }
        else  if(v.getId()==R.id.power_btn)
        {
            String c1=num3.getText().toString();
            String c2=num4.getText().toString();
            if(c1.isEmpty())
            {
                Toast.makeText(this,"Enter a number",Toast.LENGTH_SHORT).show();

            }
            if(c2.isEmpty())
            {
                Toast.makeText(this,"Enter the power u want",Toast.LENGTH_SHORT).show();
            }
            if(!c1.isEmpty() && !c2.isEmpty())
            {

                int n=Integer.parseInt(num3.getText().toString());
                int m=Integer.parseInt(num4.getText().toString());
                double s=pow(n,m);
                res2.setText(String.valueOf(s));
                myRef.child(c1+" ^ "+c2).setValue(" = "+String.valueOf(s));

            }

        }
        else
        {
            finish();
        }
    }
}
