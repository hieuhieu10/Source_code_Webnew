package com.newwebproject.Entity;

import lombok.Data;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "User")
@Data
public class UserEntity {
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
    private String userName;
    @Column
    private String passWord;
    @Column
    private String fullName;
    @Column
    private Integer status;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleEntity> roles = new ArrayList<>();
}
