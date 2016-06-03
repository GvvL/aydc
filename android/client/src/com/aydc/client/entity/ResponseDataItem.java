package com.aydc.client.entity;

public class ResponseDataItem<T extends Bean> extends ResponseDataBase{

	private T data;


	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
