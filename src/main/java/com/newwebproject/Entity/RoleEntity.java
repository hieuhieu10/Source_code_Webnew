package com.newwebproject.Entity;

import lombok.Data;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "role")
@Data
public class RoleEntity {
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

    @ManyToMany(mappedBy = "roles")//map tới thằng roles bên class UserEntity
    private List<UserEntity> users = new ArrayList<>();
}
