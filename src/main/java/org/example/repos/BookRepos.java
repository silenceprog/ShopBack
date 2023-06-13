package org.example.repos;

import org.example.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepos extends JpaRepository<ProductEntity,Long> {
//    @Query("select id,streetName from Street where id % 2 = 0")
//    List<Object[]> findIdAndStreetName();


}
