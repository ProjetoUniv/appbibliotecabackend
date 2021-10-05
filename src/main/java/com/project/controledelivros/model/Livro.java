package com.project.controledelivros.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_livros")
public class Livro  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "company")
    private String company;

    @Column(name = "positionshelf")
    private String positionShelf;

    @Column(name = "description")
    private String description;

    @Column(name = "agegroup")
    private String ageGroup;

    @Column(name = "nameimage")
    private String nameImage;

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

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }
}
