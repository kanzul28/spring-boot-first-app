package com.spring.core.view;

import com.spring.core.model.Users;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {


    List<Users> getList();

    Optional<Users> getByID(Long id);

    Map save(Users user);

    Map update(Users user, Long id);

    Map delete(Long id);


    ;
}
