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

    @Override
    public String toString() {
        return name + "\n"
                + "Model: " + model + "\n"
                + "Classification: " +starshipClass + "\n"
                + "Manufacturer: " + manufacturer + "\n"
                + "Cost(galactic credits): " + costInCredits + "\n"
                + "Length: " + length + "\n"
                + "Crew: " + crew + "\n"
                + "Passengers: " + passengers + "\n"
                + "Max atmosphering speed: " + maxAtmospheringSpeed + "\n"
                + "Hyperdrive rating: " + hyperdriveRating + "\n"
                + "MGLT(max speed in megalights/hour: " + mglt + "\n"
                + "Cargo capacity(kg): " + cargoCapacity + "\n"
                + "Consumables: " + consumables;

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