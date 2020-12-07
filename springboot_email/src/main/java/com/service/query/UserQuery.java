package com.service.query;

import java.io.Serializable;

import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class UserQuery  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8002733942253388107L;
	private int id;
	private String name;
	private String sex;
	private int age;

}
