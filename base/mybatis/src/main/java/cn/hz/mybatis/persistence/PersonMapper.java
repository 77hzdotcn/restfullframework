package cn.hz.mybatis.persistence;

import cn.hz.mybatis.domain.Person;

public interface PersonMapper {

	Person selectPersonById(Integer id);
	
}
