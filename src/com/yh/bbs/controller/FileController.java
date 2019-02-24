package com.yh.bbs.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileController {

	File fSource = null;
	
	

	public FileController(String strName) {
		this.fSource = new File(strName);
	}
	public FileController(File file) {
		this.fSource = file;
	}
	
	public void appendLine(String data) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(this.fSource,true));

		bw.write(data); //쓰기
		bw.newLine();	//개행

		bw.flush();
		bw.close();
	}
	public ArrayList<String> readAll_withLineArray() {
		ArrayList<String> linelist = new ArrayList();
		BufferedReader br = null; 
		String line = null;

		try {
			br = new BufferedReader(new FileReader(this.fSource));
			while( (line = br.readLine()) != null) {
				linelist.add(line);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return linelist;
		
	}
	public void copy(String strDest) throws IOException {
		File fDest = new File(strDest);

		FileInputStream 	fis = new FileInputStream(this.fSource);
		FileOutputStream 	fos	= new FileOutputStream(fDest);
		int data = 0;
		
		while( (data = fis.read() ) != -1) {
			fos.write(data);
		}

		fis.close();
		fos.close();
	}

	public String getFileName () {
		return	this.fSource.getName();
	}
	
	public static void make_always(String path, String strType) throws IOException {
		File fPath = new File(path);
		if ( !fPath.exists() ) 
			if ( strType.equals("dir") ) 	fPath.mkdirs();
			else if (strType.equals("file"))fPath.createNewFile();
	}
}
