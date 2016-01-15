package cn.hz.jerseyspring;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ret")
public class Result {

	private int status = 200;

	private List<String> list = new ArrayList<String>();

	@XmlElement(name = "s1")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@XmlElement(name = "dataL")
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
