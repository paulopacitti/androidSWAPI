package models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Film implements Serializable
{
    public String title;

    @SerializedName("episode_id")
    public int episodeId;

    public ArrayList<String> getCharactersUrls() {
        return charactersUrls;
    }

    public void setCharactersUrls(ArrayList<String> charactersUrls) {
        this.charactersUrls = charactersUrls;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    @Override
    public String toString()
    {
        return title + "\n"
                + "Episode: " + episodeId + "\n"
                + "Director: " + director + "\n"
                + "Producer: " + producer + "\n"
                + "Release date: " + releaseDate.toString() + "\n"
                + "Opening crawl: \n" + openingCrawl;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public ArrayList<String> getSpeciesUrls() {
        return speciesUrls;
    }

    public void setSpeciesUrls(ArrayList<String> speciesUrls) {
        this.speciesUrls = speciesUrls;
    }

    public ArrayList<String> getStarshipsUrls() {
        return starshipsUrls;
    }

    public void setStarshipsUrls(ArrayList<String> starshipsUrls) {
        this.starshipsUrls = starshipsUrls;
    }

    public ArrayList<String> getVehiclesUrls() {
        return vehiclesUrls;
    }

    public void setVehiclesUrls(ArrayList<String> vehiclesUrls) {
        this.vehiclesUrls = vehiclesUrls;
    }

    public ArrayList<String> getPlanetsUrls() {
        return planetsUrls;
    }

    public void setPlanetsUrls(ArrayList<String> planetsUrls) {
        this.planetsUrls = planetsUrls;
    }

    @SerializedName("opening_crawl")

    public String openingCrawl;

    public String director;
    public String producer;
    public String url;
    public String created;
    public String edited;

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @SerializedName("release_date")
    public String releaseDate;

    @SerializedName("starships")
    public ArrayList<String> starshipsUrls;

    @SerializedName("vehicles")
    public ArrayList<String> vehiclesUrls;

    @SerializedName("planets")
    public ArrayList<String> planetsUrls;

    @SerializedName("characters")
    public ArrayList<String> charactersUrls;

    @SerializedName("species")
    public ArrayList<String> speciesUrls;
}