package com.xaygc;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.util.StringUtils;

public class Yandaifu extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�����������õ��˲���request�������ȿ��Եõ���ͻ��˵�����ֵ");
		String cityNo = request.getParameter("city");
		String cityName = "";
		System.out.println("cityNo: " + cityNo);
		if ("1".equals(cityNo)) {
			cityName = "����";
		} else if ("2".equals(cityNo)) {
			cityName = "�ٷ�";
		} else if ("3".equals(cityNo)) {
			cityName = "����";
		} else if ("4".equals(cityNo)) {
			cityName = "����";
		} else if ("5".equals(cityNo)) {
			cityName = "�Ӱ�";
		}
		System.out.println("����: " + cityName);
		
		String sexNo = request.getParameter("sex");
		String sex = "";
		System.out.println("sexNo: " + sexNo);
		if ("1".equals(sexNo)) {
			sex = "��";
		} else if ("2".equals(sexNo)) {
			sex = "Ů";
		} else if ("3".equals(sexNo)) {
			sex = "Female-Man";
		}
		System.out.println("�Ա�: " + sex);
		
		
		System.out.println("userName = " + request.getParameter("userName"));
		System.out.println("money = " + request.getParameter("money"));
		
		System.out.println("money = " + request.getParameter("money"));
		System.out.println("���������˵�޵��˰�֢");
	
		request.setAttribute("bingming", "��ϲ��");
		request.setAttribute("zhenduanren", "yangdaifu");
			
		/*//����˵��С��ʿ�������������ȡ�� /Lidaifu
		RequestDispatcher xhs = request.getRequestDispatcher("Lidaifu");
		//С��ʿ˵�������߰ɣ������˴�����Ĳ���
		xhs.forward(request, response);*/
		
		//response.sendRedirect("Lidaifu");
		String excelPath = request.getParameter("userName");
		File file = new File(excelPath);
		String error = "";
		if (!file.exists()) {
			excelPath = excelPath.substring(excelPath.indexOf("\\") + 2, excelPath.length());
			error = excelPath + " does not exist!!!!";
			System.out.println(excelPath + " does not exist!!!!");
		}
		
		String disPath= "";
		if (!"".equals(error) && error != null) {
			disPath = "/index.jsp?error="+error;
		}else {
			disPath = "Lidaifu";
		}
		/*RequestDispatcher xhs = request.getRequestDispatcher(disPath);
		
		//С��ʿ˵�������߰ɣ������˴�����Ĳ���
		xhs.forward(request, response);*/
		
		response.sendRedirect(request.getContextPath() + disPath);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�����ϴ�����õ��˲���request�������ȿ��Եõ���ͻ��˵�����ֵ");
		System.out.println("userName = " + request.getParameter("userName"));
		System.out.println("money = " + request.getParameter("money"));
		System.out.println("�ϴ�������˵�޵��˰�֢");
		request.setAttribute("bingming", "aizheng");
		request.setAttribute("zhenduanren", "yandaifu");
		//�ϴ��˵��С��ʿ�������������ȡ�� /Lidaifu
		RequestDispatcher xhs = request.getRequestDispatcher("Lidaifu");
		//С��ʿ˵�������߰ɣ������˴�����Ĳ���
		xhs.forward(request, response);
	}

}
