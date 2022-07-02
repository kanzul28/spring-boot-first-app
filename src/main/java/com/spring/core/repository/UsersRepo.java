package com.spring.core.repository;


import com.spring.core.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

@Repository


public interface UsersRepo extends PagingAndSortingRepository<Users, Long> {
    @Query("select c from Users c")// nama class
    public List<Users> getList();
    @Query("select c from Users c WHERE c.id = :id")
    public Users getbyID(@Param("id") Long id);

}
