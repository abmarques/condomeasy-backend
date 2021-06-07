package com.condomeasy.backend.validator;

import com.condomeasy.backend.dto.user.UserDTO;
import com.condomeasy.backend.dto.user.UserUpdateDTO;
import com.condomeasy.backend.exception.BusinessException;
import com.condomeasy.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static com.condomeasy.backend.constant.MessageBundle.INVALID_EMAIL;
import static com.condomeasy.backend.constant.MessageBundle.INVALID_USERNAME;

@Component
public class CheckUserUpdateValidator {

    @Autowired
    private IUserService service;

    public void isValidUpdate(Integer id, UserUpdateDTO dto) {

       var validUsername = existsUsername(id, dto.getUsername());
       if(!validUsername) {
           throw new BusinessException(INVALID_USERNAME, HttpStatus.BAD_REQUEST.value());
       }

        var validEmail = existsEmail(id, dto.getEmail());
       if(!validEmail) {
           throw new BusinessException(INVALID_EMAIL, HttpStatus.BAD_REQUEST.value());
       }
    }

    private boolean existsUsername(Integer id, String username) {

        UserDTO dto = new UserDTO();
        boolean isValid = true;

        try {
            dto = service.findByUsername(username);
            if(dto != null && !dto.getId().equals(id)) {
                isValid = false;
            }
        }catch (BusinessException b) {
            isValid = true;
        }

        return isValid;
    }

    private boolean existsEmail(Integer id, String email) {

        UserDTO dto = new UserDTO();
        boolean isValid = true;

        try {
            dto = service.findByEmail(email);

            if(dto != null && !dto.getId().equals(id)){
                isValid = false;
            }

        }catch (BusinessException b) {
            isValid = true;
        }

        return isValid;
    }

}
