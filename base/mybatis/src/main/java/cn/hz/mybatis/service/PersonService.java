package cn.hz.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hz.mybatis.domain.Person;
import cn.hz.mybatis.persistence.PersonMapper;

@Service
public class PersonService {
	
	@Autowired
	PersonMapper personMapper;
	
	public Person queryPerson(int id){
		return personMapper.selectPersonById(id);
	}
	
}
