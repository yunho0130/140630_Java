package org.han.service;

import org.han.dao.MP3DAO;

public class MP3Service {
	private MP3DAO dao;

	public void setDao(MP3DAO dao) {
		this.dao = dao;
	}
	public String getMP3List() throws Exception{
		return dao.getTableList();
	}
}
