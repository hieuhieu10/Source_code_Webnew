//tầng connect database thuc thi cau lenh sql
package com.newwebproject.Repository;

import com.newwebproject.Entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

public interface NewRepository extends JpaRepository< NewEntity, Long> {

    //void delete(Long ids );


//  void delete(long item);
}
