package com.elead.training;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.*; 
public class Test01 {


	public static void main(String[] args) {
		 	List<Student> list=new ArrayList<Student>();
	        Sheet sheet;
	        Workbook book;
	        Cell cell1,cell2,cell3;
	        try { 
	            //t.xlsΪҪ��ȡ��excel�ļ���
	            book= Workbook.getWorkbook(new File("C:/Users/j/Desktop/Ա����Ϣ.xls")); 
	             
	            //��õ�һ�����������(ecxel��sheet�ı�Ŵ�0��ʼ,0,1,2,3,....)
	            sheet=book.getSheet(0); 
	            //��ȡ���Ͻǵĵ�Ԫ��
	           // cell1=sheet.getCell(0,0);
	            //System.out.println(cell1.getContents()); 
	           
	            
	            
	            
	            int i=0;   
	            while(true)
	            {
	            	 cell1=sheet.getCell(0,i);//���У��У�
		             cell2=sheet.getCell(1,i);
	           	 if("".equals(cell1.getContents())==true)    //�����ȡ������Ϊ��
	                    break;
	           	Student st=new Student();
	                //��ȡÿһ�еĵ�Ԫ�� 
	               
	                String name=cell1.getContents();
	                String Email=cell2.getContents();
	                st.setName(name);
	                st.setEmail(Email);                    
	                list.add(st);
	                System.out.println(cell1.getContents()+"\t"+cell2.getContents()+"\t"); 
	                i++;
	            }
	           
	            book.close(); 
	        
	           
	           
	            
	            
	            book.close(); 
	        }
	        catch(Exception e)  { } 
	    }

	

}
