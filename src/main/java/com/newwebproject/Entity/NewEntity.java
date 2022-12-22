package com.newwebproject.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "new")
@Data
public class NewEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//hỗ trợ tự động tăng
    private Long id;

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
