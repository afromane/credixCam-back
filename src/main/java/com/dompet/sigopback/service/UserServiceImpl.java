package com.dompet.sigopback.service;
import com.dompet.sigopback.entity.Role;
import com.dompet.sigopback.entity.RoleEnum;
import com.dompet.sigopback.entity.User;
import com.dompet.sigopback.exception.EntityNotFoundException;
import com.dompet.sigopback.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl  implements  UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public void create(User user){
        if (!user.getEmail().contains("@") )  {
           throw  new RuntimeException("Email not match");
        }
        if ( !user.getEmail().contains(".") ) {
           throw  new RuntimeException("Email non match");
        }
        Optional<User> userOptional = this.userRepository.findByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw  new RuntimeException("Your email is already used");
        }
       user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        /*Role userRole = new Role();
        userRole.setLabel(RoleEnum.ADMINISTRATOR);
        user.setRole(userRole);*/
        this.userRepository.save(user);

    }

    public List<User> findAll(){
        Optional<List<User>> optionalUsers = Optional.of(this.userRepository.findAll());
        return optionalUsers.orElseThrow(
                ()-> new EntityNotFoundException("Not Founds")
        );
    }
    public User findByEmail(String email){
        Optional<User> optionalUser = this.userRepository.findByEmail(email);
        return optionalUser.orElseThrow(
                ()-> new EntityNotFoundException("Not found")
        ) ;
    }


}
