package com.lanhu.cn.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ExcelUpload {

	
	public static void main(String[] args) {
		String s = "C:/Users/charlie/Desktop";
		try {
			InputStream is = new FileInputStream(s);
			System.out.println("aaaaaaaa");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
