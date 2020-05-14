package com.ibm.fsd.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginForm {
    
    @NotBlank
    private String email;
    
    @NotBlank
    private String password;
}
