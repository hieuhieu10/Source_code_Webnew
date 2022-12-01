//tầng connect database thuc thi cau lenh sql
package com.newwebproject.Repository;

import com.newwebproject.Entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository< NewEntity, Long> {

}
