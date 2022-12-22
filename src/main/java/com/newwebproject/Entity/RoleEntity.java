package com.newwebproject.Entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "role")
@Data
public class RoleEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//hỗ trợ tự động tăng
    private Long id;
    @Column
    private String code;
    @Column
    private String name;

    @ManyToMany(mappedBy = "roles")//map tới thằng roles bên class UserEntity
    private List<UserEntity> users = new ArrayList<>();
}
