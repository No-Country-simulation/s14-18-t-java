package com.awaregaming.AwareGaming.controller;

import com.awaregaming.AwareGaming.dto.UserRequestDto;
import com.awaregaming.AwareGaming.dto.UserResponseDto;
import com.awaregaming.AwareGaming.model.User;
import com.awaregaming.AwareGaming.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/api/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/all")
    public List<UserResponseDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody UserRequestDto userRequestDto){
        return userService.updateUser(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }

}