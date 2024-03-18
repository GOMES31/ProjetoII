package com.example.centrocultural.Service.User;

import com.example.centrocultural.Entity.User;
import com.example.centrocultural.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository){
        userRepository = theUserRepository;
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User findById(int theId){
        Optional<User> result = userRepository.findById(theId);

        User theUser = null;

        if(result.isPresent()){
            theUser = result.get();
        }else{
            //não encontrou o user

            throw new RuntimeException("Did not find user id - " + theId);
        }

        return theUser;
    }

    @Override
    public User save(User theUser){
       return userRepository.save(theUser);
    }

    @Override
    public void deteById(int theId){
        userRepository.deleteById(theId);
    }
}
