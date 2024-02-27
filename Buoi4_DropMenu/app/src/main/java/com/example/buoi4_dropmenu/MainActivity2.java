package com.example.buoi4_dropmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView ketqua;
    Button btnBack;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ketqua= (TextView) findViewById(R.id.textViewKetQua);
        btnBack= findViewById(R.id.btnBack);
        Intent intent1=getIntent();
        Bundle bundle=intent1.getBundleExtra("myBundle");
        if(bundle!= null){
            String ht= bundle.getString("Ho ten");
            ketqua.setText(ht);
        }
       // String ht=intent1.getStringExtra("Ho ten");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}