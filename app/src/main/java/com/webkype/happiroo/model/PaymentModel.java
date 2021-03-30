package com.webkype.happiroo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class PaymentModel implements Parcelable {

    private int image;
    private String name;
    private String id;

    public PaymentModel(int image, String name, String id) {
        this.image = image;
        this.name = name;
        this.id = id;
    }

    public PaymentModel() {
    }

    protected PaymentModel(Parcel in) {
        image = in.readInt();
        name = in.readString();
        id = in.readString();
    }

    public static final Creator<PaymentModel> CREATOR = new Creator<PaymentModel>() {
        @Override
        public PaymentModel createFromParcel(Parcel in) {
            return new PaymentModel(in);
        }

        @Override
        public PaymentModel[] newArray(int size) {
            return new PaymentModel[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(name);
        dest.writeString(id);
    }
}
