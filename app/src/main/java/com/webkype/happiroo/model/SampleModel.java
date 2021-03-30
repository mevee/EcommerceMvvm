package com.webkype.happiroo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SampleModel implements Parcelable {

    private String image;
    private String name;
    private String desc;

    public SampleModel(String image, String name, String desc) {
        this.image = image;
        this.name = name;
        this.desc = desc;
    }

    public SampleModel() {
    }

    protected SampleModel(Parcel in) {
        image = in.readString();
        name = in.readString();
        desc = in.readString();
    }

    public static final Creator<SampleModel> CREATOR = new Creator<SampleModel>() {
        @Override
        public SampleModel createFromParcel(Parcel in) {
            return new SampleModel(in);
        }

        @Override
        public SampleModel[] newArray(int size) {
            return new SampleModel[size];
        }
    };

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeString(name);
        dest.writeString(desc);
    }
}
