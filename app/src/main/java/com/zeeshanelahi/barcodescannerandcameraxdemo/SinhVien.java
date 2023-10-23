package com.zeeshanelahi.barcodescannerandcameraxdemo;
public class SinhVien {

    public String mssv;
    public String lop;

    public SinhVien() {
    }
    public SinhVien(String mssv, String lop) {
        setMssv(mssv);
        setLop(lop);
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        if (mssv.isEmpty()){
            this.mssv = "23000001";
        }
        else{
            this.mssv = mssv;
        }
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        if (lop.isEmpty()){
            this.lop = "DHKTPM18CTT";
        }
        else{
            this.lop = lop;
        }

    }
}
