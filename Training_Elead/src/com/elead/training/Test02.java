package com.elead.training;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jxl.*; 
import jxl.read.biff.BiffException;
public class Test02 {
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
	        
	}
}

	        
