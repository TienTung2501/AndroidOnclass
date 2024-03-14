package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText textSbd,textHoten,textToan,textLy,textHoa,textKetQua;
    RadioButton radioButtonNam,radioButtonNu;
    CheckBox checkbox;
    Button btnGui;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSbd= findViewById(R.id.editTextSBD);
        textHoten=findViewById(R.id.editTextHoten);
        textToan=findViewById(R.id.editTextToan);
        textLy=findViewById(R.id.editTextLy);
        textHoa=findViewById(R.id.editTextHoa);
        textKetQua=findViewById(R.id.editTextKetQua);
        radioButtonNam=findViewById(R.id.radioBtnNam);
        radioButtonNu=findViewById(R.id.radioBtnNu);
        btnGui=findViewById(R.id.buttonGui);
        checkbox=findViewById(R.id.checkBoxUuTien);
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                String sbd=textSbd.getText().toString();
                String hoten=textHoten.getText().toString();
                String toan=textToan.getText().toString();
                String hoa=textHoa.getText().toString();
                String ly=textLy.getText().toString();
                String gioitinh,uutien;
                if(radioButtonNam.isChecked()){
                    gioitinh="Nam";
                }
                else gioitinh="Nu";
                if(checkbox.isChecked())
                    uutien="Có";
                else
                    uutien="Không";
                Bundle bundle=new Bundle();
                bundle.putString("sbd",sbd);
                bundle.putString("hoten",hoten);
                bundle.putString("toan",toan);
                bundle.putString("ly",ly);
                bundle.putString("hoa",hoa);
                bundle.putString("gioitinh",gioitinh);
                bundle.putString("uutien",uutien);
                intent.putExtra("myBundle",bundle);
                Intent intent1=getIntent();
                String ketqua= intent1.getStringExtra("ketqua");
                textKetQua.setText(ketqua);
                startActivity(intent);
            }
        });

    }
}