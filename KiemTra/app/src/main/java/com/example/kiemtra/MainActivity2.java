package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textSBD,textHoten,textToan,textLy,textHoa,textUutien,textGioitinh;
    Button btnBack;
    double tongDiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textSBD=findViewById(R.id.textViewSobaodanh);
        textHoten=findViewById(R.id.textViewToan);
        textGioitinh=findViewById(R.id.textViewGioitinh);
        textUutien=findViewById(R.id.textViewUutien);
        textToan=findViewById(R.id.textViewToan);
        textLy=findViewById(R.id.textViewLy);
        textHoa=findViewById(R.id.textViewHoa);
        btnBack=findViewById(R.id.btnBack);

        Intent intent1=getIntent();
        Bundle bundle=intent1.getBundleExtra("myBundle");
        if(bundle!= null){
            String hoten= bundle.getString("hoten");
            String sbd=bundle.getString("sbd");
            String gioitinh=bundle.getString("gioitinh");
            String uutien=bundle.getString("uutien");
            String toan=bundle.getString("toan");
            String ly=bundle.getString("ly");
            String hoa=bundle.getString("hoa");
            textSBD.setText(sbd);
            textHoten.setText(hoten);
            textGioitinh.setText(gioitinh);
            textUutien.setText(uutien);
            textLy.setText(ly);
            textHoa.setText(hoa);
            textToan.setText(toan);

            double diemtoan=Double.parseDouble(textToan.getText().toString());
            double diemly=Double.parseDouble(textLy.getText().toString());
            double diemhoa=Double.parseDouble(textLy.getText().toString());
            tongDiem=diemhoa+diemtoan+diemly;

        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                String ketqua;
                if(tongDiem>=16){
                    ketqua="Đỗ";
                }
                else ketqua="Trượt";
                intent.putExtra("ketqua", ketqua);
                startActivity(intent);
            }
        });


    }
}