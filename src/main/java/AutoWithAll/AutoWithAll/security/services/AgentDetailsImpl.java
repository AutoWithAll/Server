package AutoWithAll.AutoWithAll.security.services;

import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AgentDetailsImpl {
    @Autowired
    private UserRepository userRepository;

    public User editNormalUserEditProfile(User user){
        System.out.println(user.getFname());
        return userRepository.save(user);
    }
}
