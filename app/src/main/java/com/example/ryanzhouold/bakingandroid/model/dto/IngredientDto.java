package com.example.ryanzhouold.bakingandroid.model.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class IngredientDto implements Parcelable {
    private double quantity;
    private String measure;

    /* example
    {
        "quantity": 2,
        "measure": "CUP",
        "ingredient": "Graham Cracker crumbs"
      },
     */

    @SerializedName("ingredient")
    private String name;

    protected IngredientDto(Parcel in) {
        quantity = in.readDouble();
        measure = in.readString();
        name = in.readString();
    }

    public static final Creator<IngredientDto> CREATOR = new Creator<IngredientDto>() {
        @Override
        public IngredientDto createFromParcel(Parcel in) {
            return new IngredientDto(in);
        }

        @Override
        public IngredientDto[] newArray(int size) {
            return new IngredientDto[size];
        }
    };

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(quantity);
        parcel.writeString(measure);
        parcel.writeString(name);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Double d = quantity;
        if(d.intValue() < d){
            stringBuilder.append(quantity + " ");
        }
        else{
            stringBuilder.append(d.intValue() + " ");
        }
        stringBuilder.append(measure + " ");
        stringBuilder.append(name);
        return stringBuilder.toString();
    }

}
