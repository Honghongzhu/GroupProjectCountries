package com.example.groupprojectcountries.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Country {
    @PrimaryKey
    @NonNull
    private String alpha2Code;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Capital")
    private String capital;

    @ColumnInfo(name = "Region")
    private String region;

    @ColumnInfo(name = "Flag")
    private String flag;

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public String getFlag() {
        return flag;
    }
}
