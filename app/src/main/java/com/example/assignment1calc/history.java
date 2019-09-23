package com.example.assignment1calc;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class history extends AppCompatActivity {

    TextView scroll;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        back=findViewById(R.id.back);
        scroll=findViewById(R.id.scroll);
        scroll.setText("clicked");
        DatabaseReference databaseReference3 = null;
        databaseReference3= FirebaseDatabase.getInstance().getReference();

        databaseReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String p1=dataSnapshot.getValue().toString();
                StringBuilder q1=new StringBuilder("");
                //StringBuilder q1=new StringBuilder("");
                int l=p1.length();
                for(int i=0;i<l;i++)
                {
                    if(p1.charAt(i)=='{' || p1.charAt(i)=='}')
                    {


                    }
                    else if(p1.charAt(i)==',')
                    {

                        q1.append("\n");
                    }
                    else
                    {
                        q1.append(p1.charAt(i));
                    }

                }

                scroll.setText(q1);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



}
