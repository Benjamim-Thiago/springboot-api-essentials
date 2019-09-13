package br.com.btsoftware.model;

public class PageRequestModel {
	private int page;
	private int size;
	
	
	public PageRequestModel() {
		super();
	}

	public PageRequestModel(int page, int size) {
		super();
		this.page = page;
		this.size = size;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
