package cn.hz.validation.test;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class ValidationBean {

	@NotNull
	private Integer type;

	@NotBlank
	private String name;

	private String description;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
