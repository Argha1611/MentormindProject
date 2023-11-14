package com.project.mentormind.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.project.mentormind.entity.Test;
import com.project.mentormind.entity.User;
import com.project.mentormind.repository.UserRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/form")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        Test test = new Test(Arrays.asList("Blood Test", "Eye Test", "Hearing Test", "ECG", "USG", "CT Scan", "Biopsy", "Gastroscopy", "X Rays", "MRI Scan"));
        model.addAttribute("tests", test.getTests());
        return "userForm";
    }
    @PostMapping("/save")
    public String saveUser(User user, @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
        	byte[] bytes = file.getBytes();
        	Path path = Paths.get(file.getOriginalFilename());
            Files.write(path, bytes);
            user.setImageFileName(file.getOriginalFilename());
            System.out.println("Uploaded File Name: " + file.getOriginalFilename());
            System.out.println("File Size: " + file.getSize() + " bytes");
        }
        userRepository.save(user);
        ModelAndView modelAndView = new ModelAndView("orderSuccess");
        modelAndView.addObject("successMessage", "Test Ordered and Prescription Uploaded Successfully!");
        return "orderSuccess";
    }
}
