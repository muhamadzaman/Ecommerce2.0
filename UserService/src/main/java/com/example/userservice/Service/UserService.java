package com.example.userservice.Service;

import com.example.userservice.Model.Product;
import com.example.userservice.Model.User;
import com.example.userservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public void addUser(User user) {
        userRepo.save(user);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public List<Product> getProductsByUser(Long id) {
        return userRepo.findById(id).get().getProducts();
    }


    public void update(long id, User targetUser) {
        User user = userRepo.findById(id).get();
        user.setName(targetUser.getName());
        user.setUser_name(targetUser.getUser_name());
        user.setCnic(targetUser.getCnic());
        user.setEmail(targetUser.getEmail());
        user.setPassword(targetUser.getPassword());
        userRepo.save(user);
        System.out.println("updated");
    }

}
