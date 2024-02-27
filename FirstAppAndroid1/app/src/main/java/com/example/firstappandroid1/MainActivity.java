package com.example.firstappandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button bt;
    TextView bmi,category;
    EditText a,b;
    ImageView mbi;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bmi= (TextView) findViewById(R.id.BMI);
        mbi= (ImageView) findViewById(R.id.imageViewMBI) ;
        a = (EditText) findViewById(R.id.editA);
        b= (EditText) findViewById(R.id.editB);
        bt = (Button) findViewById(R.id.button);
        category= (TextView) findViewById(R.id.category);
//        image = (ImageView) findViewById(R.id.imageView);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double x= Double.parseDouble(a.getText().toString());
                double y= Double.parseDouble(b.getText().toString());
                double z= (double) x /(y*y);
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                DecimalFormat df=new DecimalFormat("#.#");
                bmi.setText(String.valueOf(df.format(z)));
                String text;
                if(z>=0&& z<15)
                    text="Very severly";
                else if (z>=15&& z<16){
                    mbi.setImageResource(R.drawable.mbi_gayf);
                    text="servely underweight";
                }

                else if (z>=16&& z<18.5){
                    mbi.setImageResource(R.drawable.mbi_gayf);
                    text="underweight";
                }

                else if (z>=18.5&& z<25){
                    mbi.setImageResource(R.drawable.mbi_binhthuong);
                    text="heavy weight";
                }

                else if (z>=25 && z<30){
                    mbi.setImageResource(R.drawable.mbi_binhthuong);
                    text="over weight";
                }

                else if (z>=30&& z<35){
                    mbi.setImageResource(R.drawable.mbi_beo);
                    text="moderately obese";
                }

                else if (z>=35&& z<40){
                    mbi.setImageResource(R.drawable.mbi_beo);
                    text="servely obese";
                }

                else{
                    mbi.setImageResource(R.drawable.mbi_beo);
                    text="very servely obese";
                }
                category.setText(text);

//
            }
        });

    }
}