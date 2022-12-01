//tầng connect database thuc thi cau lenh sql
package com.newwebproject.Repository;
import com.newwebproject.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    //find lấy dữ liệu
    CategoryEntity findOneByCode(String code);
}
