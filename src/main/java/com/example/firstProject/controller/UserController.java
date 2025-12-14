package com.example.firstProject.controller;

import com.example.firstProject.modal.User;
import com.example.firstProject.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return repo.findAll();
    }
    @PostMapping("/")
//    public User postUser(String name,String email){
//        User newUser=new User();
//        newUser.setName(name);
//        newUser.setEmail(email);
//        User savedUser=repo.save(newUser);
//        return savedUser;
//
//
//    }
    public User postUserBody(@RequestBody User newUser){
        User savedUser=repo.save(newUser);
        return savedUser;

    }

    @PutMapping("/{id}")
    public User putUser(@RequestBody User updatedUser,@PathVariable Long id){
        System.out.printf(String.valueOf(id));
        Optional<User> existingUser=repo.findById(id);
        if(existingUser.isPresent()){
            User userToUpdate=existingUser.get();
            userToUpdate.setName(updatedUser.getName());
            userToUpdate.setEmail(updatedUser.getEmail());
            return repo.save(userToUpdate);
        }else{return null;}

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        Optional<User> userToDelete=repo.findById(id);
        if(userToDelete.isPresent()){
            repo.deleteById(id);
            return ResponseEntity.ok().build();
//            return ResponseEntity.ok("User with id"+id+"deleted successfully");
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}
