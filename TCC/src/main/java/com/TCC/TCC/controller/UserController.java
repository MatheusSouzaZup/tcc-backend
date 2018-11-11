package com.TCC.TCC.controller;

import com.TCC.TCC.model.User;
import com.TCC.TCC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> Post(@RequestBody User user) {
        return new ResponseEntity(this.userService.Create(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> Put( @RequestBody User user, @PathVariable("id") Long id) {
        return new ResponseEntity(this.userService.Update(id, user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> Put( @PathVariable("id") Long id) {
        return new ResponseEntity(this.userService.Delete(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<User>> Get() {
        return new ResponseEntity(this.userService.Find(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> Get( @PathVariable("id") Long id) {
        return new ResponseEntity(this.userService.Find(id), HttpStatus.OK);
    }
}
