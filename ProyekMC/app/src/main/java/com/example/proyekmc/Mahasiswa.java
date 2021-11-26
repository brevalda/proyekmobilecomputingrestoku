package com.example.proyekmc;

import android.os.Parcel;
import android.os.Parcelable;


public class Mahasiswa implements Parcelable {

    private String nrp;
    private String nama;
    private String gender;
    private String major;

    public Mahasiswa(String nrp, String nama, String gender, String major) {
        this.nrp = nrp;
        this.nama = nama;
        this.gender = gender;
        this.major = major;
    }

    protected Mahasiswa(Parcel in) {
        nrp = in.readString();
        nama = in.readString();
        gender = in.readString();
        major = in.readString();
    }

    public static final Creator<Mahasiswa> CREATOR = new Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel in) {
            return new Mahasiswa(in);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nrp);
        parcel.writeString(nama);
        parcel.writeString(gender);
        parcel.writeString(major);
    }
}
