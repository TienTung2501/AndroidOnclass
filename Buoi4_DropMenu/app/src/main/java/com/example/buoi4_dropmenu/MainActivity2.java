package com.example.buoi4_dropmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView ketqua1,ketqua2,ketqua3;
    Button btnBack;
    double nghiem=-1;
    String conghiem;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ketqua1= (TextView) findViewById(R.id.textViewKetQua1);
        ketqua2=findViewById(R.id.textViewKetQua3);
        ketqua3=findViewById(R.id.textViewSo3);
        btnBack= findViewById(R.id.btnBack);
        Intent intent1=getIntent();

        if(intent1!= null){

             int a= intent1.getIntExtra("a",-1);
             int b=intent1.getIntExtra("b",-1);
             int c=intent1.getIntExtra("c",-1);
             ketqua1.setText(String.valueOf(a));
             ketqua2.setText(String.valueOf(b));
             ketqua3.setText(String.valueOf(c));
             if(a==0&&b==0&&c==0){
                 conghiem="Vo so nghiem";
             }
             else if(a==0&&b==0&&c!=0){
                 conghiem="Vo nghiem";
            }
             else{
                 conghiem="Co nghiem";
                 nghiem=(c-b)/a;
            }


        }


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                ;
                intent.putExtra("tong",nghiem);
                intent.putExtra("conghiem",conghiem);
                setResult(33,intent);
                finish();
            }
        });
    }
}