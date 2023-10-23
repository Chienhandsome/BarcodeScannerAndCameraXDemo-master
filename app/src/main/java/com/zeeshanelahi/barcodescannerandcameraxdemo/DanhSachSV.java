package com.zeeshanelahi.barcodescannerandcameraxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DanhSachSV extends AppCompatActivity {

    ImageButton backBT;
    String link = "https://mssvscanner-default-rtdb.asia-southeast1.firebasedatabase.app";
    FirebaseDatabase database = FirebaseDatabase.getInstance(link);
    private ArrayList<SinhVien> sinhviens = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ds_sinh_vien);

        backBT = findViewById(R.id.backButton);

        backBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DanhSachSV.this, Menu.class);
                startActivities(new Intent[]{intent});
            }
        });

        taoAdapter(sinhviens);
    }

    public void taoAdapter(ArrayList<SinhVien> sinhviens){
        ArrayAdapter<SinhVien> adapter = new ArrayAdapter<SinhVien>(this, R.layout.info_sv_row, R.id.mssv, sinhviens) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                SinhVienViewHolder viewHolder;

                // Nếu convertView là null, nghĩa là đây là lần đầu tiên hiển thị mục ListView này.
                // Tạo một ViewHolder mới và lưu trữ tham chiếu đến các view trong layout.
                if (convertView == null) {
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_sv_row, parent, false);
                    viewHolder = new SinhVienViewHolder(convertView);
                    convertView.setTag(viewHolder);
                } else {
                    // Lấy ViewHolder từ convertView.
                    viewHolder = (SinhVienViewHolder) convertView.getTag();
                }

                // Lấy dữ liệu sinh viên từ adapter.
                SinhVien sinhVien = sinhviens.get(position);

                // Hiển thị dữ liệu sinh viên lên các view trong layout.
                viewHolder.mssvTextView.setText(sinhVien.getMssv());
                viewHolder.lopTextView.setText(sinhVien.getLop());

                return convertView;
            }
        };
        ListView listView = findViewById(R.id.listview_ds_sinh_vien);
        listView.setAdapter(adapter);
    }



    public class SinhVienViewHolder {
        public TextView mssvTextView;
        public TextView lopTextView;

        public SinhVienViewHolder(View view) {
            mssvTextView = view.findViewById(R.id.mssv);
            lopTextView = view.findViewById(R.id.lop);
        }
    }

    public void themSinhVien(SinhVien sv){
        sinhviens.add(sv);
    }
}
