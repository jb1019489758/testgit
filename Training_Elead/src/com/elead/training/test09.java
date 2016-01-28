package com.elead.training;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import jxl.*;
import jxl.read.biff.BiffException;

public class test09 {
	public static void main(String[] args) throws BiffException, IOException {
		//获取文件路径
		String info=readProperties("src/infor.txt");
		String input_path,output_path;
		  //System.out.println(info);
		  String st1[]=info.split(",");
		  input_path=st1[0];
		  output_path=st1[01];
		 
		
		// 文件读取
		List list = new ArrayList();
		Load(list,input_path);
		// 链表倒置
		Change(list);
		// 拼接字符串
		String str = new String();
		str = Pin(list);
		// 文件写入
		Write(str,output_path);
		System.out.println("文件已经写入！");
	
	}

	// 文件读取
	public static void Load(List list,String input_path) throws BiffException, IOException {
		Sheet sheet;
		Workbook book;
		Cell cell1, cell2;
		
		book = Workbook.getWorkbook(new File(input_path));
		sheet = book.getSheet(0);
		int rowNum=sheet.getRows();
		for (int i = 0; i < rowNum; i++) {
			Student st = new Student();
			cell1 = sheet.getCell(0, i);// （列，行
			cell2 = sheet.getCell(1, i);
			String name = cell1.getContents();
			String Email = cell2.getContents();
			st.setName(name);
			st.setEmail(Email);
			list.add(st);
		}
	}

	// 字符串拼接
	public static String Pin(List list) {
		String str = new String();
		for (int i = 0; i <= list.size() - 1; i++) {
			str += list.get(i);
			str += "\r\n";
		}
		return str;
	}

	// 文件写入
	public static void Write(String str,String output_path) throws IOException {
		FileWriter fw = new FileWriter(output_path);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(str);
		bw.newLine();
		bw.close();

	}

	// 链表倒置
	public static void Change(List list) {
		Object info, info1;
		for (int i = 1; i <= (list.size() / 2); i++) {
			info = list.get(i);// 保存前面的数字
			info1 = list.get(list.size() - i);// 保存后面的数字
			list.set(i, info1);
			list.set(list.size() - i, info);
		}
	}

	  public static String readProperties(String filePath) {
		     Properties props = new Properties();
		      String info="";
		        try {
		         InputStream in = new BufferedInputStream (new FileInputStream(filePath));
		         props.load(in);
		            Enumeration en = props.propertyNames();
		             while (en.hasMoreElements()) {
		              String key = (String) en.nextElement();
		                    String Property = props.getProperty (key);
		                    //System.out.println(key+Property);
		                   info+= Property+",";
		                   
		                }
		             
		        } catch (Exception e) {
		         e.printStackTrace();
		        }
		        return info;
		    }
}
