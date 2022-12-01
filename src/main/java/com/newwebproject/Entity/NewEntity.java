package com.newwebproject.Entity;
import lombok.Data;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "new")
@Data
public class NewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//hỗ trợ tự động tăng
    private Integer id;
    @Column
    private String createdBy;
    @Column
    private Date createdDate;
    @Column
    private String modifiedBy;
    @Column
    private Date modifiedDate;
    @Column // tạo column trong database table
    private String title;
    @Column //(name = "thumbnail") name để nó gener vào database
    private String thumbnail;
    @Column
    private String shortDescription;
    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

}
