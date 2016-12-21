/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.repositories.impl;

import com.zcon.mobileris.config.ProjectConstants;
import com.zcon.mobileris.entity.UserManagement;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.zcon.mobileris.repositories.interfaces.IUserManagementRepository;
import java.io.File;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author PradnyaS
 */
@Repository("userManagementRepository")
public class UserManagementRepositoryImpl extends AbstractRepository<Integer, UserManagement> implements IUserManagementRepository {

    
    @Override
    public List<UserManagement> getAllUserManagement() {
        return createCriteria().add(Restrictions.eq("isDeleted", false)).addOrder(Order.asc("userName")).list();
    }

    @Override
    public UserManagement createUserManagement(UserManagement user) {
        //UserNameRepositoryImpl userNameGenerator = new UserNameRepositoryImpl();
        String userName = generateUserName(user.getFirstName(), user.getLastName());
       // String profilepath = generateProfilePath(user,userName);
        user.setUserName(userName);
        user.setProfilePicPath(ProjectConstants.FINAL_FILE_UPLOAD_DIR + userName + ".jpg");
        persist(user);
        return user;
    }

    @Override
    public UserManagement getUserManagementByUserManagementId(int userId) {
         return getByKey(userId);
    }

    @Override
    public UserManagement updateUserManagement(UserManagement user) {
        update(user);
        return user;
    }

    @Override
    public boolean deleteUserManagement(int userId) {
        boolean result = true;
        UserManagement user = (UserManagement) createCriteria().add(Restrictions.eq("userId", userId)).uniqueResult();
        user.setIsDeleted(result);
        update(user);
        return result;
    }
    
      public String generateUserName(String firstName,String LastName)
    {
        String userName = "";
        Session session = getSession();//sessionFactory.getCurrentSession();//Session();//withOptions().tenantIdentifier("tenant5").openSession();
        //Session session = sessionFactory.withOptions().tenantIdentifier(username_part2).openSession();
       // Transaction transaction = session.beginTransaction();
        session.flush();
        Query q=session.createQuery("select userName from UserManagement where userId = (SELECT max(userId) FROM UserManagement WHERE roleType IN (2,3) )");  
        //int count = q.executeUpdate();
        List<UserManagement> allUser = q.list();
        int lastId=0;
        if(allUser.isEmpty()){
            lastId = 001;
        }
        else{
            Iterator it = allUser.iterator();
            while(it.hasNext()){
                String lastUserName = (String) it.next();
                System.out.println("-------------LastUserName------------ "+lastUserName);
                String lastUserId = lastUserName.substring(lastUserName.indexOf("@") + 1);
                int nextId = Integer.parseInt(lastUserId);
                lastId = nextId + 1;
            }
        }
        String fname = firstName.substring(0, 1);
        String lastIdFormat = String.format("%1$03d", lastId);
        userName = fname + LastName + "@" + lastIdFormat;
        
       // transaction.commit();
        //session.close();
        return userName;
    }
//     public String generateProfilePath(UserManagement user, String userName)
//    {
//        MultipartFile profilePic = user.getFile();
//            File dir = new File(ProjectConstants.FINAL_FILE_UPLOAD_DIR + userName);
//            String filePath = ProjectConstants.FINAL_FILE_UPLOAD_DIR + userName + "\\";
//            String fileName = userName + ".jpg";
//            dir.mkdirs();
//       
//        if(result.hasErrors())
//        {
//            throw new FileUploadException(profilePic.getOriginalFilename(),"File is missing");
//        }
//        else
//        {
//             try {
//                 FileCopyUtils.copy(profilePic.getBytes(),new File(filePath + fileName));//profilePic.getOriginalFilename()));
//             } catch (IOException ex) {
//                 Logger.getLogger(UserManagementServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//             }
//        }
//    }
}
