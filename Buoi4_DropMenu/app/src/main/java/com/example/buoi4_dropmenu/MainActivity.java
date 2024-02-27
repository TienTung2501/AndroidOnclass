package com.example.buoi4_dropmenu;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ListView listViewMonHoc;
    Spinner spinner;
    ArrayList<String> arrayListMonhoc;
    ArrayAdapter<String> adapterListView;
    ArrayAdapter<String> adapterSpinner;
    TextInputEditText nhapMonHoc,editTextHoTen;
    Button them,save,login,send;

    int index;
    double tien = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        them=findViewById(R.id.button);
        save =findViewById(R.id.button2);
        listViewMonHoc = findViewById(R.id.ListViewMonHoc);
        spinner = findViewById(R.id.spinnerMonHoc);
        nhapMonHoc=findViewById(R.id.textInputEditText);
        login= (Button) findViewById(R.id.Login);
        send =(Button) findViewById(R.id.btnSend) ;
        editTextHoTen= findViewById(R.id.sendata);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callMyDialog();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                String ht=editTextHoTen.getText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("Ho ten", ht);
                intent.putExtra("myBundle",bundle);
                intent.putExtra("Ho ten",ht);
                startActivity(intent);
            }
        });
        // Initialize the ArrayList
        arrayListMonhoc = new ArrayList<>();
        arrayListMonhoc.add("Data mining");
        arrayListMonhoc.add("Java");
        arrayListMonhoc.add("Android");
        arrayListMonhoc.add("Game");
        arrayListMonhoc.add("Image processing");
        // khoi tao list chua cac mon hoc
        // tao listadapter truyn list mon hoc vao
        // set listview o layout va truyen adapter vao
        // viet cac su kien cho list view
        // ListView Adapter
        adapterListView = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, arrayListMonhoc);
        listViewMonHoc.setAdapter(adapterListView);

        // ListView Item Click Listener
        listViewMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayListMonhoc.get(position), Toast.LENGTH_SHORT).show();
                String s=arrayListMonhoc.get(position);
                nhapMonHoc.setText(s);
                index=position;
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListMonhoc.set(index,nhapMonHoc.getText().toString());
                adapterListView.notifyDataSetChanged();
            }
        });


        // Spinner Adapter
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_item, arrayListMonhoc);
        spinner.setAdapter(adapterSpinner);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=nhapMonHoc.getText().toString();

                if(!arrayListMonhoc.contains(s))
                    arrayListMonhoc.add(s);
                else
                    Toast.makeText(MainActivity.this, "Da ton tai mon hoc", Toast.LENGTH_SHORT).show();
                adapterSpinner.notifyDataSetChanged();
                adapterListView.notifyDataSetChanged();
            }

        });
        // Spinner Item Selected Listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayListMonhoc.get(position), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle nothing selected
            }
        });
        spinner.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayListMonhoc.remove(position);
                adapterSpinner.notifyDataSetChanged();
                adapterListView.notifyDataSetChanged();
                return true;
            }
        });
        listViewMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Remove the item from the ArrayList

                xacNhanXoa(position);
                // Notify the adapter that the data set has changed
//                arrayListMonhoc.remove(position);
//                adapterListView.notifyDataSetChanged();
//                adapterSpinner.notifyDataSetChanged();
                // Consume the long click event
                return true;
            }
        });
    }
    private void xacNhanXoa(final int position){
        AlertDialog.Builder aler= new AlertDialog.Builder(this);
        aler.setTitle("Thong bao");
        aler.setIcon(R.mipmap.ic_launcher);
        aler.setMessage("Có chắc chắc xóa không?");
        aler.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrayListMonhoc.remove(position);
                adapterListView.notifyDataSetChanged();
            }
        });
        aler.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing or handle the cancellation
            }
        });
        aler.show(); // You missed to call show() to display the dialog
    }
    private void callMyDialog(){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        TextInputEditText userName,passWord;
        Button login,cancel;
        userName = dialog.findViewById(R.id.edittextUserName);
        passWord = dialog.findViewById(R.id.edittextPassWord);
        login = dialog.findViewById(R.id.btnLogin);
        cancel = dialog.findViewById(R.id.btnCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=userName.getText().toString();
                String pass=passWord.getText().toString();
                if(name.equals("abcd")&& pass.equals("1234")){
                    Toast.makeText(MainActivity.this,"Correct",Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(MainActivity.this,"Not Correct",Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }

}
