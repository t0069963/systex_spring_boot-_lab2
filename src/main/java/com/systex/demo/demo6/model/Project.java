package com.systex.demo.demo6.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String projectName;
    private String projectIdentifier;
    private String description;
    private Date startDate;
    private Date endDate;
    private Date createdAt;
    private Date updatedAt;
    @PrePersist//EntityManager儲存Entity之前呼叫
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate//EntityManager將Entity與資料庫同步更新發生前呼叫
    protected  void onUpdate() {
        this.updatedAt = new Date();
    }
}