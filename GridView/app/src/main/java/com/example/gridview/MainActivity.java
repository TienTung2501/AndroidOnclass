package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Hinhanh> arrayListImage;
    HinhanhAdapter adapter;
    // khai báo kiểu dữ liệu cho gridview đó
    // tạo layout
    // truyền adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView= findViewById(R.id.GridView);
        arrayListImage = new ArrayList<>();
        arrayListImage.add(new Hinhanh("Hinh so 1",R.drawable.anh1));
        arrayListImage.add(new Hinhanh("Hinh so 2",R.drawable.anh2));
        arrayListImage.add(new Hinhanh("Hinh so 3",R.drawable.anh3));
        adapter = new HinhanhAdapter(MainActivity.this,
                R.layout.ohinhanh, arrayListImage);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        arrayListImage.get(i).getTen(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
// làm game lật ảnh,4*4 nếu nhap 2 vector neu 2 anh trung nhau thi true
// random
