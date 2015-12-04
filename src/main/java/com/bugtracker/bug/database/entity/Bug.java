package com.bugtracker.bug.database.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bug")
@Entity
@Table(name = "Bug")
public class Bug {

    @Id
    @GeneratedValue
    private Integer idBug;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String status;

    @Column
    private String idProject;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    public Integer getIdBug() {
        return idBug;
    }

    public void setIdBug(Integer idBug) {
        this.idBug = idBug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
