package br.com.btsoftware.model;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int totalElement;
	private int pageSize;
	private int totalPage;
	private List<T> elements;
	
	public PageModel() {
		super();
	}
	
	public PageModel(int totalElement, int pageSize, int totalPage, List<T> elements) {
		super();
		this.totalElement = totalElement;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.elements = elements;
	}
	public int getTotalElement() {
		return totalElement;
	}
	public void setTotalElement(int totalElement) {
		this.totalElement = totalElement;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getElements() {
		return elements;
	}
	public void setElements(List<T> elements) {
		this.elements = elements;
	}
	
	
}
