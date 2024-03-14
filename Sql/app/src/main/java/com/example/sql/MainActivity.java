package com.example.sql;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    Button btnInsert,btnDelete,btnUpdate,btnDisplay;
    TextView textViewKetQua;

    TextInputEditText editTextId,editTextHoTen,editTextNamSinh;

    MyDbHelper myDbHelper=new MyDbHelper(this);

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myDbHelper.openDb();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myDbHelper.closeDb();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ht=editTextHoTen.getText().toString();
                int ns=Integer.parseInt(editTextNamSinh.getText().toString());
                long resultInsert=myDbHelper.Insert(ht,ns);
                if(resultInsert==-1){
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();


                }
                else {
                    Toast.makeText(MainActivity.this,"Insert Success",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(editTextId.getText().toString());
                String ht=editTextHoTen.getText().toString();
                int ns=Integer.parseInt(editTextNamSinh.getText().toString());
                long resultUpdate=myDbHelper.Update(id,ht,ns);
                if(resultUpdate==-1){
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Update Success",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer buffer=new StringBuffer();
                Cursor cursor= myDbHelper.DisplayAll();
                for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                    buffer.append(cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.getId())));
                    buffer.append("-");
                    buffer.append(cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.getName())));
                    buffer.append("-");
                    buffer.append(cursor.getString(cursor.getColumnIndexOrThrow(MyDbHelper.getYEAROB())));
                    buffer.append("-");

                }
                textViewKetQua.setText(buffer);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(editTextId.getText().toString());
                long resultDelete= myDbHelper.Delete(id);
                if(resultDelete==-0){
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Delete Success",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initComponent() {
        btnInsert=findViewById(R.id.buttonInsert);
        btnUpdate=findViewById(R.id.buttonUpdate);
        btnDisplay=findViewById(R.id.buttonDisplay);
        btnDelete=findViewById(R.id.buttonDelete);
        textViewKetQua=findViewById(R.id.textViewKetQua);
        editTextId=findViewById(R.id.editTextId);
        editTextHoTen=findViewById(R.id.editTextHoTen);
        editTextNamSinh=findViewById(R.id.editTextNamSinh);
    }
}