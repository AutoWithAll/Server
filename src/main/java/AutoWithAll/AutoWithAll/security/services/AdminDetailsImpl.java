package AutoWithAll.AutoWithAll.security.services;
import AutoWithAll.AutoWithAll.models.Test;
import AutoWithAll.AutoWithAll.models.User;
import AutoWithAll.AutoWithAll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDetailsImpl {
    @Autowired
    private UserRepository userRepository;
    public User editAdminDetails(User user){
        System.out.println(user.getFname());
        return userRepository.save(user);
    }
}
