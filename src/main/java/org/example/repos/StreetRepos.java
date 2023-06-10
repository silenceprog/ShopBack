//package org.example.repos;
//
//import org.example.domain.Street;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;
//
//
//public interface StreetRepos extends CrudRepository<Street,Integer> {
//    @Query("select id,streetName from Street where id % 2 = 0")
//    List<Object[]> findIdAndStreetName();
//
//}
