package com.newwebproject.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Category")
public class CategoryEntity {
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
    @Column
    private String code;
    @Column
    private String name;

    @OneToMany(
            mappedBy = "category"//map tới category trong Class CategoryEntity (table category)
    )
    private List<NewEntity> news = new ArrayList<>();// 1cate thì có nhiều new
}
