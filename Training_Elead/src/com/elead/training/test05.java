package com.elead.training;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jxl.*;
import jxl.read.biff.BiffException;

public class test05 {
	public static void main(String[] args) throws BiffException, IOException {
		// 文件读取
		List list = new ArrayList();
		Load(list);
		// 链表倒置
		Change(list);
		// 拼接字符串
		String str = new String();
		str = Pin(list);
		// 文件写入
		Write(str);
		System.out.println("文件已经写入！");
	}

	// 文件读取
	public static void Load(List list) throws BiffException, IOException {
		Sheet sheet;
		Workbook book;
		Cell cell1, cell2;
		String input_path="E:/mycode/Training_Elead/员工信息.xls";
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
	public static void Write(String str) throws IOException {
		FileWriter fw = new FileWriter("E:/mycode/Training_Elead/jiangbo.csv");
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

}
