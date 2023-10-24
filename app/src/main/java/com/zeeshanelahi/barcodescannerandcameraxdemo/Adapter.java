package com.zeeshanelahi.barcodescannerandcameraxdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private DanhSachSV context;
    private int layout;
    private List<SinhVien> sinhVienList;
    public Adapter(DanhSachSV context, int layout, List<SinhVien> sinhVienList) {
        this.context = context;
        this.layout = layout;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView tvLop;
        TextView tvMSSV;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = new ViewHolder() ;
        if (view == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);

            holder.tvMSSV =  view.findViewById(R.id.mssv);
            holder.tvLop =  view.findViewById(R.id.lop);


            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        final SinhVien sinhVien = sinhVienList.get(i);

        holder.tvMSSV.setText(sinhVien.getMssv());
        holder.tvLop.setText(sinhVien.getLop());
        return view;
    }
}
