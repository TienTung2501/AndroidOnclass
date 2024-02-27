package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidgets();
    }
    private void InitWidgets() {
        textview = (TextView) findViewById(R.id.textView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();// lay menu tu giao dien xml
        inflater.inflate(R.menu.main_menu,menu);// hien thi len giao dien
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mnuGreen){
            textview.setBackgroundColor(Color.GREEN);
        }if(item.getItemId()==R.id.mnuBle){
            textview.setBackgroundColor(Color.BLUE);
        }if(item.getItemId()==R.id.mnuRed){
            textview.setBackgroundColor(Color.RED);
        }
        return super.onOptionsItemSelected(item);
    }



}