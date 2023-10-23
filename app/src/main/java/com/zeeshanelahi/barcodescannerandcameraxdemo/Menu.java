package com.zeeshanelahi.barcodescannerandcameraxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Menu extends AppCompatActivity {

    Button quet;
    Button showDS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);



        quet = findViewById(R.id.button_Quet);
        showDS = findViewById(R.id.button_DS_Sinh_Vien);

        quet.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, BarcodeScannerActivity.class);
            startActivities(new Intent[]{intent});
        });

        showDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, DanhSachSV.class);
                startActivities(new Intent[]{intent});
            }
        });

    }
}
