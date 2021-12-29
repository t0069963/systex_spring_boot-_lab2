package com.systex.demo.demo6.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "project name is required")
    private String projectName;
    @NotBlank(message = "project Identifier is required")
    @Size(min=6, max=16, message="idenfier should between 6 to 16")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;
    @NotBlank(message = "description not blank")
    private String description;
    private Date startDate;
    private Date endDate;
    private Date createdAt;
    private Date updatedAt;
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected  void onUpdate() {
        this.updatedAt = new Date();
    }
}