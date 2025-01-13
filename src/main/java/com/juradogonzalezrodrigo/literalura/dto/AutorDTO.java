package com.juradogonzalezrodrigo.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("birth_year")
    private int birth_year;

    @JsonProperty("death_year")
    private int death_year;

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", birth_year=" + birth_year +
                ", death_year=" + death_year +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public int getDeath_year() {
        return death_year;
    }

    public void setDeath_year(int death_year) {
        this.death_year = death_year;
    }
}
