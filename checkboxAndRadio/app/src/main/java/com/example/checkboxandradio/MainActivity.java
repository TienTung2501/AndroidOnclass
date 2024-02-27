package com.example.checkboxandradio;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    String s="";
    TextInputEditText ten,soluong,dongia,tongtien;
    RadioButton nam,nu;
    CheckBox Vip;
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ten=(TextInputEditText) findViewById(R.id.edittxtTenKH);
        soluong= (TextInputEditText) findViewById(R.id.textInputEditTextSoLuong);
        dongia= (TextInputEditText) findViewById(R.id.textInputEditTextDonGia);
        tongtien=(TextInputEditText) findViewById(R.id.edittextTongTien);
        nam= (RadioButton) findViewById(R.id.radioButtonNam);
        nu=(RadioButton) findViewById(R.id.radioButtonNu);
        Vip=(CheckBox) findViewById(R.id.checkBoxVIP);
        if(ten.getText().toString()!="" &&soluong.getText().toString()!=""&& dongia.getText().toString()!=""){
            s+=ten.getText().toString();
            double tongtienmua;
            double soluongmua=Double.parseDouble(soluong.getText().toString());
            double dongiamua=Double.parseDouble(dongia.getText().toString());
            if(nu.isChecked()||Vip.isChecked()){
                tongtienmua=soluongmua*dongiamua*0.9;
            }
            else tongtienmua=soluongmua*dongiamua;
            tongtien.setText(String.valueOf(tongtienmua));
        }


    }
}