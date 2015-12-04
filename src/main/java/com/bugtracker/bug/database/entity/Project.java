package com.bugtracker.bug.database.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "project")
@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue
    private Integer idProject;

    @Column
    private String name;


    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}