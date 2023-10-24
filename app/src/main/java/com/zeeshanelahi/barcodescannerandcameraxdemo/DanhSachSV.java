package com.zeeshanelahi.barcodescannerandcameraxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class DanhSachSV extends AppCompatActivity {

    ImageButton backBT;
    public ArrayList<SinhVien> sinhviens = new ArrayList<>();
    Adapter adapter = new Adapter(this,R.layout.info_sv_row,sinhviens);

    ListView listView;
    String link = "https://mssvscanner-default-rtdb.asia-southeast1.firebasedatabase.app";
    FirebaseDatabase database = FirebaseDatabase.getInstance(link);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ds_sinh_vien);

        anhXa();

        listView.setAdapter(adapter);

        SinhVien sv = new SinhVien("123","123");
        sinhviens.add(sv);
        adapter.notifyDataSetChanged();

        getNewData();
        Toast.makeText(this, "so sinh vien " + sinhviens.size() , Toast.LENGTH_SHORT).show();

        backBT.setOnClickListener(view -> {
            Intent intent = new Intent(DanhSachSV.this, Menu.class);
            startActivities(new Intent[]{intent});
        });
    }

    public void getNewData(){

        DatabaseReference reference = database.getReference();
        reference.child("Danh Sách Sinh Viên").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String mssv = snapshot.getValue().toString();
                SinhVien sv = new SinhVien(mssv,"xyz");

                sinhviens.add(sv);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                String mssv = snapshot.getValue().toString();
                SinhVien sv = new SinhVien(mssv,"xyz");

                sinhviens.remove(sv);
                adapter.notifyDataSetChanged();
                Toast.makeText(DanhSachSV.this, "Có sự thay đổi dữ liệu!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void anhXa(){
        backBT = findViewById(R.id.backButton);
        listView = findViewById(R.id.listview_ds_sinh_vien);
    }
}
