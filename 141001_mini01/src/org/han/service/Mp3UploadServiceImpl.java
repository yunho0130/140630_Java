package org.han.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.han.vo.MP3;

class Mp3UploadServiceImpl implements Mp3UploadService {

	private static final String ROOT = "c:\\zzz";
	private List<MP3> mp3List;
	
	public Mp3UploadServiceImpl(){
		mp3List = new ArrayList<MP3>();
		
		File[] file = new File(ROOT).listFiles();
		
		for(File file2 : file ){
			mp3List.add(new MP3(file2.getName(), file2.getPath()));
			//mp3List.add(new MP3(file2.getName(), file2.getAbsolutePath()));
		}
	}
	
	@Override
	public List<MP3> getFolderList(String dirName) {
		// TODO Auto-generated method stub
		return mp3List;
	}

	@Override
	public void addMp3(MP3 mp3) {
		
		mp3List.add(mp3);
	}

	@Override
	public void removeMp3(String fileName) {
		// TODO Auto-generated method stub

	}

}
