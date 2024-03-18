package com.example.centrocultural.Controller;

import com.example.centrocultural.Entity.Invoice;
import com.example.centrocultural.Entity.User;
import com.example.centrocultural.Service.User.UserService;
import com.example.centrocultural.Service.User.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService theUserService){
        userService = theUserService;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{userId")
    public User getUser(@PathVariable int userId){

        User theUser = userService.findById(userId);

        // lança uma exceção se o valor retornado for null
        if(theUser == null){
            throw new RuntimeException("User id not found - " + userId);
        }

        return theUser;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User theUser){

        // No caso de utilizador passar um Id como parametro, definir o Id como 0 para ser gerado automaticamente
        // isto é para forçar a guardar um item novo, e não atualizar um item já existente

        theUser.setId(0);

        User dbUser = userService.save(theUser);

        return dbUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser) {

        User dbUser = userService.save(theUser);

        return dbUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId){

        User tempUser = userService.findById(userId);

        // lança uma exceção se o valor retornado for null
        if(tempUser== null){
            throw new RuntimeException("User id not found - " + userId);
        }

        userService.deteById(userId);

        return "Deleted user id - " + userId;

    }
}
