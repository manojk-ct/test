package com.zcon.mobileris.services.impl;

import com.zcon.mobileris.config.ProjectConstants;
import com.zcon.mobileris.entity.AbstractCommonEntity;
import com.zcon.mobileris.entity.Country;
import com.zcon.mobileris.entity.States;
import com.zcon.mobileris.entity.UserManagement;
import com.zcon.mobileris.exceptions.FileUploadException;
import com.zcon.mobileris.models.dto.UserManagementDTO;
import com.zcon.mobileris.repositories.interfaces.IConvertToBO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zcon.mobileris.services.interfaces.IUserManagementService;
import com.zcon.mobileris.repositories.interfaces.IUserManagementRepository;
import com.zcon.mobileris.services.interfaces.IConvertToDTO;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author PradnyaS
 */
@Service("userManagementService")
@Transactional
public class UserManagementServiceImpl implements IUserManagementService,IConvertToDTO,IConvertToBO  {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    IUserManagementRepository userManagementRepository;
    
    @Autowired
    ModelMapper modelMapper;
    

    @Override
    public List<UserManagementDTO> getAllUserManagement() {
        List<UserManagement> uList = userManagementRepository.getAllUserManagement();
        List<UserManagementDTO> uDTOList = new ArrayList<>();
        for(UserManagement user:uList){
            uDTOList.add((UserManagementDTO) _toDTO(user));
        }
        return uDTOList;
    }

    @Override
    public UserManagementDTO createUserManagement(UserManagementDTO user,BindingResult result) throws IOException{
        UserManagement userBO = (UserManagement) _toBO(user);  
        UserManagementDTO dto = (UserManagementDTO) _toDTO(userManagementRepository.createUserManagement(userBO));
        MultipartFile profilePic = user.getFile();
        String profilePicName = dto.getUserName();
        // user.setUserName(username);
            //File dir = new File(ProjectConstants.FINAL_FILE_UPLOAD_DIR + profilePicName);
            String filePath = ProjectConstants.FINAL_FILE_UPLOAD_DIR ;
            String fileName = profilePicName + ".jpg";
            //dir.mkdirs();
        if(result.hasErrors())
        {
            throw new FileUploadException(profilePic.getOriginalFilename(),"File is missing");
        }
        else
        {
            FileCopyUtils.copy(profilePic.getBytes(),new File(filePath + fileName));//profilePic.getOriginalFilename()));
        }
        
       //UserManagement userBO = (UserManagement) _toBO(user);
       //userBO.setProfilePicPath(filePath + fileName);//profilePic.getOriginalFilename());
       return dto;//(UserManagementDTO) _toDTO(userManagementRepository.createUserManagement(userBO));
    }

    @Override
    public UserManagementDTO getUserManagementByUserManagementId(int userId) {
        return (UserManagementDTO)_toDTO(userManagementRepository.getUserManagementByUserManagementId(userId));
    }

    @Override
    public UserManagementDTO updateUserManagement(UserManagementDTO user,BindingResult result){
       
        //String username , username_part1 = null ,filePath = null,fileName = null;
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //if (authentication != null) {
          //  username = authentication.getName();
           // username_part1 = username.substring(username.indexOf("#") + 1);
           
        
        UserManagement userBO = (UserManagement) _toBO(user);
       // userBO.setProfilePicPath(filePath + fileName);
        return (UserManagementDTO) _toDTO(userManagementRepository.updateUserManagement(userBO));
    }

    @Override
    public boolean deleteUserManagement(int userId) {
        return userManagementRepository.deleteUserManagement(userId);
    }

    @Override
    public Object _toDTO(Object bo) {
        UserManagement user = (UserManagement) bo;
        UserManagementDTO dto=modelMapper.map(user, UserManagementDTO.class);
        dto.setCountryId(user.getCountry().getCountry_id());
        dto.setStateId(user.getStateObject().getState_id());
        return dto;
    }

    @Override
    public Object _toBO(Object dto) {
        String username , username_part1 = " " ,userName="";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            username = authentication.getName();
            username_part1 = username.substring(username.indexOf("#") + 1);
        }
        
        UserManagementDTO userDTO = (UserManagementDTO) dto;
        //userName=generateUserName(userDTO.getFirstName(),userDTO.getLastName());
        //userDTO.setUserName(userName);
        Country country = new Country();
        country.setCountry_id(userDTO.getCountryId());
        States state =  new States();
        state.setState_id(userDTO.getStateId());
        AbstractCommonEntity abEntity = new AbstractCommonEntity();
        abEntity.setCreatedBy(username_part1);
        abEntity.setUpdatedBy(username_part1);
        
        UserManagement userBO = modelMapper.map(userDTO, UserManagement.class);
        userBO.setCountry(country);
        userBO.setStateObject(state);
        userBO.setCommonComponent(abEntity);
        return userBO;
    }

   
}
