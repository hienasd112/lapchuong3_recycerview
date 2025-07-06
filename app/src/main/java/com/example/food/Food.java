package com.example.food;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {
    private String name;
    private int imageResId;
    private String description;
    private int price;

    public Food(String name, int imageResId, String description, int price) {
        this.name = name;
        this.imageResId = imageResId;
        this.description = description;
        this.price = price;
    }

    protected Food(Parcel in) {
        name = in.readString();
        imageResId = in.readInt();
        description = in.readString();
        price = in.readInt();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imageResId);
        dest.writeString(description);
        dest.writeInt(price);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getName() { return name; }
    public int getImageResId() { return imageResId; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }
}
