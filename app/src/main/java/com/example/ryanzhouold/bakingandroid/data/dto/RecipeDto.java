package com.example.ryanzhouold.bakingandroid.data.dto;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeDto implements Parcelable {
    private long id;
    private String name;

    private IngredientDto[] ingredientDtos;
    private StepDto[] stepDtos;
    private int servings;
    private String image;

    protected RecipeDto(Parcel in) {
        id = in.readLong();
        name = in.readString();
        ingredientDtos = in.createTypedArray(IngredientDto.CREATOR);
        stepDtos = in.createTypedArray(StepDto.CREATOR);
        servings = in.readInt();
        image = in.readString();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: "+ id + "\n");
        sb.append("name: "+ name + "\n");
        return sb.toString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeTypedArray(ingredientDtos, flags);
        dest.writeTypedArray(stepDtos, flags);
        dest.writeInt(servings);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RecipeDto> CREATOR = new Creator<RecipeDto>() {
        @Override
        public RecipeDto createFromParcel(Parcel in) {
            return new RecipeDto(in);
        }

        @Override
        public RecipeDto[] newArray(int size) {
            return new RecipeDto[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientDto[] getIngredientDtos() {
        return ingredientDtos;
    }

    public void setIngredientDtos(IngredientDto[] ingredientDtos) {
        this.ingredientDtos = ingredientDtos;
    }

    public StepDto[] getStepDtos() {
        return stepDtos;
    }

    public ArrayList<? extends Parcelable> getStepsAsParcelableArrayList() {
        return (ArrayList<? extends Parcelable>)Arrays.asList(stepDtos);
    }

    public void setStepDtos(StepDto[] stepDtos) {
        this.stepDtos = stepDtos;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
