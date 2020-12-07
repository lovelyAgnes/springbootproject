package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "table_user")
public class User implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -823505272720029015L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 20, nullable = false, unique = true)
	private int id;
	private String name;
	private String pwd;
	private String sex;
	private int age;
	private String phone;
}
