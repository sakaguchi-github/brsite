package com.internousdev.book_reviewsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.ImageDAO;
import com.internousdev.book_reviewsite.dto.ImageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport implements SessionAware {

	private List<ImageDTO> imageDTO = new ArrayList<ImageDTO>();
	private Map<String, Object> session;

	public String execute() {

		ImageDAO imageDAO = new ImageDAO();
		imageDTO = imageDAO.getImage();
		session.put("imageDTO", imageDTO);

		return SUCCESS;
	}

	public List<ImageDTO> getImageDTO() {
		return imageDTO;
	}

	public void setImageDTO(List<ImageDTO> imageDTO) {
		this.imageDTO = imageDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
