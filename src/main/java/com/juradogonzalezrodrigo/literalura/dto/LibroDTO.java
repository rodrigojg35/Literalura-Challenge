package com.juradogonzalezrodrigo.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LibroDTO {

    @JsonProperty("title")
    private String title;

    @JsonProperty("authors")
    private List<AutorDTO> authors;

    @JsonProperty("languages")
    private List<String> languages;

    @JsonProperty("download_count")
    private int downloadCount;

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", authors=" + authors.toString() +
                ", languages=" + languages.toString() +
                ", downloadCount='" + downloadCount + '\'' +
                '}';
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AutorDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AutorDTO> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }


}
