package com.example.ryanzhouold.bakingandroid.model;

import com.google.gson.annotations.SerializedName;

public class Ingredient{
    private double quantity;
    private String measurement;

    /* example
    {
        "quantity": 2,
        "measure": "CUP",
        "ingredient": "Graham Cracker crumbs"
      },
     */

    @SerializedName("ingredient")
    private
    String name;

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
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
}
