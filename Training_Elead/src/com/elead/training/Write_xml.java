package com.elead.training;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.List;

public class Write_xml {
	public static String read_qq(String str) {
		String st[]=str.split("@");
		System.out.println("#######"+st[0]);
		System.out.println("#######"+st[1]);
		String s[]=st[1].split("c");
		System.out.println("#######"+s[0]);
		System.out.println("#######"+s[1]);
		return s[0];
	}
	
	public static void write_xml(List list) {
	//	List list=T_All_Method.readExcel();
		Document doc=DocumentHelper.createDocument();
		Element root=DocumentHelper.createElement("EmployeeInformation");
		doc.setRootElement(root);
		
		for (int i = 1; i < list.size(); i++) {
			String sd=list.get(i).toString();
			String st[]=sd.split(",");
			
			String qq=read_qq(st[1]);
			
			int base=100000+i;
			String ba=base+"";
			String id="20160111"+ba;
			
			Element el=root.addElement("Employee");
			el.addElement("EmployeeName").addAttribute("emplyeeId",id).addText(st[0]);
			el.addElement("EmployeeEmail").addAttribute("emialType", qq).addText(st[1]);
		}
		OutputFormat of=new OutputFormat("    ",true);
		of.setEncoding("UTF-8");
		try {
			FileOutputStream fos=new FileOutputStream("D://Student.xml");
			XMLWriter xw=new XMLWriter(fos,of);
			
			xw.write(doc);
			xw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}