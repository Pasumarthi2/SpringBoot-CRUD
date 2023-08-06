package com.kumar.app.springboot.Controller;

import com.kumar.app.springboot.Models.User;
import com.kumar.app.springboot.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;
    @GetMapping(value ="/")

    public String getPage()
    {
        return "Welcome!";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers()
    {
        return userRepo.findAll();
    }
@PostMapping(value = "/save")
    public String saveUser(@RequestBody User user)
    {
      userRepo.save(user);
      return "User Information Saved!";
    }

    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id,@RequestBody User user)
    {
        @SuppressWarnings("OptionalGetWithoutIsPresent") User updateUser = userRepo.findById(id).get();
        updateUser.setFirstname(user.getFirstname());
        updateUser.setLastname(user.getLastname());
        updateUser.setAge(user.getAge());
        updateUser.setOccupation(user.getOccupation());
        userRepo.save(updateUser);
        return "Updated id..";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id)
    {
        @SuppressWarnings("OptionalGetWithoutIsPresent") User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return  "user deleted with ID: " +id;
    }
}
