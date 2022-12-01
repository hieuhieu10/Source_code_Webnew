package com.newwebproject.Entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@MappedSuperclass
public abstract class BaseEntity {
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
}
