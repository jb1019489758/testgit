package com.elead.training;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jxl.*; 
import jxl.read.biff.BiffException;
public class Test03 {
	public static void main(String[] args) throws BiffException, IOException {
		 	
	        Sheet sheet;
	        Workbook book;
	        Cell cell1,cell2;
	        List list=new ArrayList();
	        book= Workbook.getWorkbook(new File("C:/Users/j/Desktop/员工信息.xls"));
	        sheet=book.getSheet(0);
	        for(int i=0;i<12;i++){
	        	Student st=new Student();
	        	
	        		cell1=sheet.getCell(0,i);//（列，行
	        		cell2=sheet.getCell(1,i);
	        		String name=cell1.getContents();
	                String Email=cell2.getContents();
	                st.setName(name);
	                st.setEmail(Email);                    
	                list.add(st);
	        }
	       System.out.println(list.size());
	       for(int i=1;i<12;i++){
	       System.out.println(list.get(i));}
	       //链表倒置
	       Object info,info1;
	       for(int i=1;i<=(list.size()/2);i++){
	    	 info=list.get(i);//保存前面的数字
	    	 info1=list.get(list.size()-i);//保存后面的数字
	    	 list.set(i, info1);
	    	 list.set(list.size()-i, info);
	       }
	       System.out.println("@@@@@@@@@@@@@@@");
	       for(int i=1;i<12;i++){
		       System.out.println(list.get(i));}
	       
	       File dest=new File("C:/Users/j/Desktop/jiangbo.csv");
	        OutputStream os=null;
	        os=new FileOutputStream(dest,true);
	        
	        
	      }
}

	        
