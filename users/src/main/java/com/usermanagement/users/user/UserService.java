package com.usermanagement.users.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public static boolean isValidUser(User user){
        boolean isValid = true;

        for (User u : UserRepository.getUserList()){
            if(user.getName().equalsIgnoreCase(u.getName())
            && user.getSurname().equalsIgnoreCase(u.getSurname())){
                isValid = false;
            }
        }        
        return isValid;
    }

    public static Long generateId(){
        final long minIdValue = 1L;
        final long maxIdValue = 10L;
        long randomId = minIdValue + (long) (Math.random() * (maxIdValue - minIdValue));
        return randomId;
    }
}
