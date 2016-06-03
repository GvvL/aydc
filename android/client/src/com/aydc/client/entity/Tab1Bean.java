package com.aydc.client.entity;

import java.util.ArrayList;

public class Tab1Bean extends Bean{
	private ArrayList<StoreBean> store;
	private ArrayList<BannerBean> banner;
	public ArrayList<StoreBean> getStore() {
		return store;
	}
	public void setStore(ArrayList<StoreBean> store) {
		this.store = store;
	}
	public ArrayList<BannerBean> getBanner() {
		return banner;
	}
	public void setBanner(ArrayList<BannerBean> banner) {
		this.banner = banner;
	}

}
