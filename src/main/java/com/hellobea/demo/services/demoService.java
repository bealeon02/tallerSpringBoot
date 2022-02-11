package com.hellobea.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hellobea.demo.model.Test;
import com.hellobea.demo.repository.testRepository;


@Service
public class demoService {
	
	@Autowired
	private testRepository tr;
	
	@Value("${course.message}")
	private String hello;
	
	public String muestraString( ) {
		return hello;
	}
	
	public List<Test> consultarTabla() {
		return tr.findAll();
	}
	public Test borrarCampo(int id) {
		return tr.deleteById(id);
	}
	public Test agregarCampo(Test ut) {
		return tr.save(ut);
	}
	public Test updateCampo(Test ut) {
		return tr.save(ut);
	}
}
