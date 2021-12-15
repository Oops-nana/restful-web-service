package com.restful.wj.restfulwebservice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCnt = 3;
    static{
        users.add(new User(1, "wonaje","pass1", "701031-1212121" , new Date()));
        users.add(new User(2, "two","pass2", "853431-1345122", new Date()));
        users.add(new User(3, "three", "pass3", "6534626-4526466", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++userCnt);
            user.setJoinDate(new Date());
        }
        users.add((user));
        return user;
    }

    public User findOne(int id){
        for(User user : users){
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User user = iterator.next();

            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    public User updateById(User user, int id){
        User foundUser =  findOne(id);
        foundUser.setName(user.getName());
        foundUser.setJoinDate(new Date());
        return foundUser;
    }
}
