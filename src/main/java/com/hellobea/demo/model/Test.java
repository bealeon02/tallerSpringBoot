package com.hellobea.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel("Modelo de usuario")
@Entity
@Table ( name = "test")
public class Test {
	@Id
	@ApiModelProperty(value = "Integer", example = "1")
	private int id;
	
	@ApiModelProperty(value = "String", example = "Cristina")
	private String name;
	
	@NotNull(message = "No puede estar vacio")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = Shape.STRING)
	@ApiModelProperty(value = "Date", example = "2021-08-20T00:00:00")
	private Date fecha;
	
	
	
	public Test( ) {
		
	}
	
	public int getId( ) {
			return id;		
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
