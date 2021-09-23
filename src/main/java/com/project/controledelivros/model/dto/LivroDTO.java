package com.project.controledelivros.model.dto;

import javax.validation.constraints.NotNull;

public class LivroDTO {

    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String company;

    @NotNull
    private String positionShelf;

    @NotNull
    private String description;

    @NotNull
    private String ageGroup;

    private byte[] imageBook;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPositionShelf() {
        return positionShelf;
    }

    public void setPositionShelf(String positionShelf) {
        this.positionShelf = positionShelf;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public byte[] getImageBook() {
        return imageBook;
    }

    public void setImageBook(byte[] imageBook) {
        this.imageBook = imageBook;
    }


}