package com.xingyi.logistic.authentication.bean;

import com.xingyi.logistic.business.bean.BaseModelAndDO;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 上午12:37.
 */
public class BaseUserProfile extends BaseModelAndDO {
	private String nickName;
	private String realName;
	private int gender;
	private String birthDay;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
}
