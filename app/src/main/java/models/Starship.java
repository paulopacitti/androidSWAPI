package models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Starship extends Vehicle implements Serializable
{

    @SerializedName("starship_class")
    public String starshipClass;

    @SerializedName("hyperdrive_rating")
    public String hyperdriveRating;

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    public String getMglt() {
        return mglt;
    }

    public void setMglt(String mglt) {
        this.mglt = mglt;
    }

    @SerializedName("MGLT")
    public String mglt;

}