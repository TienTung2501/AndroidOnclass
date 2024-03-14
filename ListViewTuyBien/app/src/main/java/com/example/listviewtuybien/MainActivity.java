package com.example.listviewtuybien;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    SinhVienAdapter adapter;
    Button btnThem,btnEdit,btnSearch,btnXoa,btnGui;
    TextInputEditText editTextHoTen,editTextNamSinh;
    int positionSave,xoaitem;
    private ActivityResultLauncher<Intent> activityResultLauncher=
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==33){
                        Intent intent=result.getData();
                        int t=intent.getIntExtra("tong",-1);

                    }
                }
            });
    ArrayList<SinhVien> sinhViensList;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        adapter= new SinhVienAdapter(MainActivity.this,R.layout.item,sinhViensList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this,sinhViensList.get(position).hoTen +" "+ sinhViensList.get(position).namSinh,Toast.LENGTH_SHORT).show();
                editTextHoTen.setText(sinhViensList.get(position).hoTen.toString());
                editTextNamSinh.setText(String.valueOf(sinhViensList.get(position).namSinh));
                positionSave=position;
                xoaitem=position;
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                xoaitem=position;
                xacNhanXoa(xoaitem);
                return false;
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten;
                Integer namsinh;
                hoten=editTextHoTen.getText().toString();
                namsinh=Integer.parseInt(editTextNamSinh.getText().toString());
                sinhViensList.add(new SinhVien(hoten,namsinh));
                adapter.notifyDataSetChanged();

            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten;
                Integer namsinh;
                hoten=editTextHoTen.getText().toString();
                namsinh=Integer.parseInt(editTextNamSinh.getText().toString());
                sinhViensList.set(positionSave,new SinhVien(hoten,namsinh));
                adapter.notifyDataSetChanged();
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kt=0;
                String ht=editTextHoTen.getText().toString();
                for(int i=0;i<sinhViensList.size();i++){
                    if(sinhViensList.get(i).hoTen.equals(ht)){
                        kt=1;
                        editTextNamSinh.setText(String.valueOf(sinhViensList.get(i).namSinh));
                    }
                }
                if(kt==0)
                    editTextNamSinh.setText("Khong có sinh viên");

            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sinhViensList.remove(xoaitem);
                adapter.notifyDataSetChanged();
            }
        });
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuly();
            }
        });

// giơ tay
    }
    private void xuly() {
        Intent intent =new Intent(MainActivity.this,MainActivity2.class);
       String ht= editTextHoTen.getText().toString();
       int ns=Integer.parseInt(editTextNamSinh.getText().toString());
       SinhVien sv= new SinhVien(ht,ns);
        activityResultLauncher.launch(intent);
        //startActivityForResult(intent,99); cách lấy dữ liệu 1
    }
    private void initComponent() {
        listView= findViewById(R.id.ListViewDanhSach);
        btnThem=findViewById(R.id.buttonThem);
        btnEdit=findViewById(R.id.buttonEdit);
        btnSearch=findViewById(R.id.buttonSearch);
        btnXoa= findViewById(R.id.buttonXoa);
        editTextHoTen=findViewById(R.id.editTextHoTen);
        editTextNamSinh=findViewById(R.id.editTextNamSinh);
        btnGui=findViewById(R.id.buttonGui);
        sinhViensList=new ArrayList<>();
        sinhViensList.add(new SinhVien("Nguyen Tien Tung",2003));
        sinhViensList.add(new SinhVien("Nguyen The  Trung",2003));
        sinhViensList.add(new SinhVien("Nhu Dinh Du",2003));
    }
    private void xacNhanXoa(final int position){
        AlertDialog.Builder aler= new AlertDialog.Builder(this);
        aler.setTitle("Thong bao");
        aler.setIcon(R.mipmap.ic_launcher);
        aler.setMessage("Có chắc chắc xóa không?");
        aler.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sinhViensList.remove(xoaitem);
                adapter.notifyDataSetChanged();
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
}