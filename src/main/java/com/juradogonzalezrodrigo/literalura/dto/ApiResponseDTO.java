package com.juradogonzalezrodrigo.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.juradogonzalezrodrigo.literalura.model.Libro;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseDTO {

    @JsonProperty("results")
    private List<LibroDTO> results;

    @JsonProperty("count")
    private int count;

    public List<LibroDTO> getResults() {
        return results;
    }

    public void setResults(List<LibroDTO> results) {
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "{" +
                "results=" + results.toString() +
                '}';
    }
}