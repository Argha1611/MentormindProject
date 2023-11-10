package com.diagnosticapplication.Service;
import java.util.List;
import com.diagnosticapplication.Entity.User;
public interface UserService {
    User getUserById(Long userid);
    List<User> getAllUsers();
    User createUser(User user);
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
}