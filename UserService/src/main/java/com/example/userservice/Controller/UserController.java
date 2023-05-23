package com.example.userservice.Controller;

import com.example.userservice.Model.Product;
import com.example.userservice.Model.User;
import com.example.userservice.Service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    WebClient.Builder webClientBuilder ;

    @PostMapping
    public String addUser(
            @RequestBody User user
    ) {
        userService.addUser(user);
        return "Created";
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/{id}")
    public void updateUser(
            @PathVariable("id") long id,
            @RequestBody User targetUser
    ){
        userService.update(id , targetUser);
    }


// passing product through user
    @PostMapping(value = "/add-product")
    public Object addProduct(
            @RequestParam("product") String product,
            @RequestParam("user") String user
    ){

        System.out.println(product);
        Gson gson = new Gson();
        Product pObj = gson.fromJson(product,Product.class);
        System.out.println(pObj);
        String p =  webClientBuilder.build().post()
                .uri("http://localhost:8082/api/product")
                .syncBody(pObj)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        User uObj = gson.fromJson(user,User.class);
        System.out.println(uObj);
        String p1 =  webClientBuilder.build().post()
                .uri("http://localhost:8081/api/user")
                .syncBody(uObj)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println(p+p1);
        return "product_user added";
    }

}
