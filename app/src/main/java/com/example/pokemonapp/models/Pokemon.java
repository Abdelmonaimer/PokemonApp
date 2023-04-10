package com.example.pokemonapp.models;


import com.example.pokemonapp.Type;
import com.google.gson.annotations.SerializedName;


import java.util.List;

public class Pokemon {
    private int number;
    private String name;
    private String url;

    private String weight;
    private String height;

    @SerializedName("types")
    private List<Type> types;
    @SerializedName("stats")
    private List<Stat> stats;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        String[] urlPart = url.split("/");
        return Integer.parseInt(urlPart[urlPart.length - 1]);
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }
}
