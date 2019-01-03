package com.example.ryanzhouold.bakingandroid.model.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class StepDto implements Parcelable {
    
    private int id;
    private String shortDescription;
    private String description;
    private String videoURL;
    private String thumbnailURL;

    protected StepDto(Parcel in) {
        id = in.readInt();
        shortDescription = in.readString();
        description = in.readString();
        videoURL = in.readString();
        thumbnailURL = in.readString();
    }

    public static final Creator<StepDto> CREATOR = new Creator<StepDto>() {
        @Override
        public StepDto createFromParcel(Parcel in) {
            return new StepDto(in);
        }

        @Override
        public StepDto[] newArray(int size) {
            return new StepDto[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(shortDescription);
        parcel.writeString(description);
        parcel.writeString(videoURL);
        parcel.writeString(thumbnailURL);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        appendIfNotNull(sb, shortDescription);
        appendIfNotNull(sb, description);
        appendIfNotNull(sb, videoURL);
        appendIfNotNull(sb, thumbnailURL);
        return sb.toString();
    }

    private StringBuilder appendIfNotNull(StringBuilder sb, String string){
        if (string!=null && string.length()>0){
            sb.append(string);
            sb.append("\n");
        }
        return sb;
    }
}
