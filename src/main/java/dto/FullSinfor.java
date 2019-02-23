package main.java.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 项目名称：N03Recruit 类名称：FullSinfor 类描述： 创建人：Administrator 创建时间：2015年4月9日
 * 上午11:52:32 修改人：Administrator 修改时间：2015年4月9日 上午11:52:32 修改备注：
 * 
 * @version
 * 
 */

//控制那些字段或屬性序列化
@XmlAccessorType(XmlAccessType.FIELD)
//根元素
@XmlRootElement(name = "StudentInfo")
public class FullSinfor {

	private String name;
	private String sex;
	// 准考号
	private String examineeNum;
	private String identityNum;
	// 政治身份
	private String political;
	private String phone;
	private String address;
	private String province;
	private String acceptPerson;
	private String grades;
	private int s_id;
	
	

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getExamineeNum() {
		return examineeNum;
	}

	public void setExamineeNum(String examineeNum) {
		this.examineeNum = examineeNum;
	}

	public String getIdentityNum() {
		return identityNum;
	}

	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}

	public String getPolitical() {
		return political;
	}

	public void setPolitical(String political) {
		this.political = political;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getAcceptPerson() {
		return acceptPerson;
	}

	public void setAcceptPerson(String acceptPerson) {
		this.acceptPerson = acceptPerson;
	}

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "FullSinfor [s_id=" + s_id + ",name=" + name + ", sex=" + sex + ", examineeNum=" + examineeNum
				+ ", identityNum=" + identityNum + ", political=" + political + ", phone=" + phone + ", address="
				+ address + ", province=" + province + ", acceptPerson=" + acceptPerson + ", grades=" + grades + "]";
	}
}
