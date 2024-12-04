package com.parking.parkinglot.ejb;

import com.parking.parkinglot.entities.Car;
import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.common.UserDto;
import com.parking.parkinglot.entities.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless

public class UsersBean {
    private static final Logger LOG = Logger.getLogger(UsersBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;

    public List<UserDto> findAllUserss(){
        LOG.info("Find all users");
        try{
            TypedQuery<User> typedQuery=entityManager.createQuery("SELECT u FROM User u", User.class);
            List<User> users=typedQuery.getResultList();
            return copyUsersToDto(users);
        } catch (Exception ex){
            throw new EJBException(ex);
        }
    }

    private List<UserDto> copyUsersToDto(List<User> list){
        List<UserDto> dtos=new ArrayList<>();
        for(User user : list){
            UserDto c=new UserDto(user.getId(),user.getUsername());
            dtos.add(c);
        }
        return dtos;
    }
}
