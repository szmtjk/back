package com.xingyi.logistic.authentication.model;

import com.xingyi.logistic.business.bean.BaseQueryPage;

public class LocalAuthQuery extends BaseQueryPage {
	private String key;

	public LocalAuthQuery(){

	}

	public LocalAuthQuery(String key){
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
