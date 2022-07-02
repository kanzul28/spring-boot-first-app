package com.spring.core.repository;


import com.spring.core.model.UserDetail;
import com.spring.core.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepo extends PagingAndSortingRepository<UserDetail, Long> {

}
