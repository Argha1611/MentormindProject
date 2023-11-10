package com.diagnosticapplication.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.diagnosticapplication.Entity.User;
import com.diagnosticapplication.Service.UserService;

import java.util.List;
@Controller
//@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/getUserById/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    /*@PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }*/
    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user, Model model) {
        User newUser = userService.createUser(user);
        model.addAttribute("message", "User created successfully");
        model.addAttribute("user", newUser);
        return "index";
    }
  @PutMapping("updateUser/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }
    /*@PutMapping("/updateUser/{userId}")
    public String updateUser(@ModelAttribute Long userId, User user, Model model) {
        User editUser = userService.updateUser(userId, user);
        model.addAttribute("message", "User updated successfully");
        model.addAttribute("user", editUser);
        return "redirect:/";
    }*/
    @DeleteMapping("deleteUser/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
    /*@DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@ModelAttribute Long userId, Model model) {
        User removeUser = userService.deleteUser(userId);
        model.addAttribute("message", "User deleted successfully");
        model.addAttribute("user", removeUser);
        return "redirect:/";
    }*/
}