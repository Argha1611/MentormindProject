package com.diagnosticapplication.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diagnosticapplication.Entity.User;
import com.diagnosticapplication.Repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	public User getUserById(Long userId)
	{
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {

			return user.get();
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		 return userRepository.save(user);
	}

	@Override
	public User updateUser(Long userId, User user) {
		// TODO Auto-generated method stub
        if (userRepository.existsById(userId)) {
            user.setUserId(userId);
            return userRepository.save(user);
        }
        return null;

       
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}

}
