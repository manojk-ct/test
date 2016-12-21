package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.controllers.GlobalExceptionProcessor;
import com.zcon.mobileris.entity.User;
import com.zcon.mobileris.repositories.interfaces.UserRepository;
import java.sql.SQLException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Repository("userDao")
public class UserRepositoryImpl  implements UserRepository {//extends AbstractDao<Integer, User1>  implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;
    
        @ExceptionHandler(GlobalExceptionProcessor.class)
        @Override
	public User findByUsername(String username) {
                String username_part1 = username.substring(username.indexOf("#") + 1);
                String username_part2 = username.substring(0, username.indexOf("#"));
                User user = null;
                Session session = sessionFactory.withOptions().tenantIdentifier(username_part2).openSession();
                Transaction transaction = session.beginTransaction();
                Criteria crit = session.createCriteria(User.class);
                crit.add(Restrictions.eq("username", username_part1));
                user = (User) crit.uniqueResult();
                if (user != null) {
                    user.setTenantName(username_part2);
                    
                }
                transaction.commit();
                session.close();
                if (user != null) {
                    user.setTenantName(username_part2);
                    user.setUsername(username);
                    
                }
                return user;
	}


        
}
