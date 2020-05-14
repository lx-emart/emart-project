package com.ibm.fsd.entity;

import lombok.*;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@Table(name = "user")
public class User implements Serializable {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "username")
    private String username;
    
	@Column(name = "password")
    private String password;

	@Column(name = "email")
    private String email;
    
	@Column(name = "roles")
    private String roles;
    
	@Column(name = "confirm_password")
    private String confirmPassword;
    
	@Column(name = "mobile_number")
    private String mobileNumber;
    
	@Column(name = "contact_number")
    private String contactNumber;
    
	@Column(name = "company_name")
    private String companyName;
    
	@Column(name = "brief_about_company")
    private String briefAboutCompany;
    
	@Column(name = "postal_address")
    private String postalAddress;
    
	@Column(name = "create_time")
    @CreatedDate
    private Date createTime;
    
	@Column(name = "update_time")
    @CreatedDate
    private Date updateTime;

}

