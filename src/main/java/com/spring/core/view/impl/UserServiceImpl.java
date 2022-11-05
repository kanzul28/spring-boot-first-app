package com.spring.core.view.impl;

import com.spring.core.model.Transaksi;
import com.spring.core.model.UserDetail;
import com.spring.core.model.Users;
import com.spring.core.repository.UsersRepo;
import com.spring.core.view.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepo userRepo;
    @Override
    public List<Users> getList() {
        return null;
    }

    @Override
    public Optional<Users> getByID(Long id) {
        return Optional.empty();
    }

    @Override
    public Map save(Users user) {
        Map map = new HashMap();
        try{
            UserDetail user_detail = user.getUser_detail();
            user.setUser_detail(user_detail);
            user_detail.setUsers(user);
            Users save = userRepo.save(user);

            map.put("data", save);
            map.put("code", "200");
            map.put("status", "success");
            return map;
        }
        catch(Exception e){
            map.put("code", "500");
            map.put("status", "failed");
            return map;
        }

    }

    @Override
    public Map update(Users user, Long id) {
        return null;
    }

    @Override
    public Map delete(Long id) {
        return null;
    }
}
