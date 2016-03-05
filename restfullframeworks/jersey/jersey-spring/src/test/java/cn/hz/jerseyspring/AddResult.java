package cn.hz.jerseyspring;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.NONE)
public class AddResult extends Result1<Integer> {

	private List<String> l = new ArrayList<String>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddResult(Integer id) {
		super(id);
	}

	public AddResult() {
	}

	public AddResult(Integer id, String message) {
		super(id);
		this.setMessage(message);
	}

	@XmlAttribute(name = "code1")
	public int code = 200;

	private String message = "新增成功";

	@XmlElement(name = "info")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	@XmlElement(name = "id")
	protected Integer getPayload() {
		// TODO Auto-generated method stub
		return super.getPayload();
	}

	public void setId(Integer id) {
		setPayload(id);
	}

	@XmlElement(name = "L")
	public List<String> getL() {
		return l;
	}

	public void setL(List<String> l) {
		this.l = l;
	}

}
