package com.example.sam2023.persistance.daoFiles;

import com.example.sam2023.model.AbstractUser;
import com.example.sam2023.model.UserCredential;

public abstract class AbstractUserDAOFile<T extends AbstractUser> extends AbstractDAOFile<T>{
    public boolean authenticateUser(UserCredential u){
        for(T user : this.map.values()){
            if(user.getEmail().equals(u.getEmail()) && user.getPassword().equals(u.getPassword())){
                return true;
            }
        }
        return false;
    }
}