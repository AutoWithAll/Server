package AutoWithAll.AutoWithAll.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.repository.UserRepository;

/**
 * NormalUserImpl
 */
@Service
public class NormalUserImpl {
    @Autowired
    private UserRepository userRepository;

    public User editNormalUserEditProfile(User user){
        System.out.println(user.getFname());
        return userRepository.save(user);
    }
    
}