package com.example.ryanzhouold.bakingandroid.data.pojo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ingredient{
    @PrimaryKey
    private int id;
    private double quantity;

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    private String measure;

    public int getId() {
        return id;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getMeasure() {
        return measure;
    }
    /* example
    {
        "quantity": 2,
        "measure": "CUP",
        "ingredient": "Graham Cracker crumbs"
      },
     */


}
