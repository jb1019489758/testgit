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
		System.out.println("我是杨大夫，我拿到了病历request对象，首先可以得到你客户端的请求值");
		String cityNo = request.getParameter("city");
		String cityName = "";
		System.out.println("cityNo: " + cityNo);
		if ("1".equals(cityNo)) {
			cityName = "西安";
		} else if ("2".equals(cityNo)) {
			cityName = "临汾";
		} else if ("3".equals(cityNo)) {
			cityName = "咸阳";
		} else if ("4".equals(cityNo)) {
			cityName = "宝鸡";
		} else if ("5".equals(cityNo)) {
			cityName = "延安";
		}
		System.out.println("城市: " + cityName);
		
		String sexNo = request.getParameter("sex");
		String sex = "";
		System.out.println("sexNo: " + sexNo);
		if ("1".equals(sexNo)) {
			sex = "男";
		} else if ("2".equals(sexNo)) {
			sex = "女";
		} else if ("3".equals(sexNo)) {
			sex = "Female-Man";
		}
		System.out.println("性别: " + sex);
		
		
		System.out.println("userName = " + request.getParameter("userName"));
		System.out.println("money = " + request.getParameter("money"));
		
		System.out.println("money = " + request.getParameter("money"));
		System.out.println("杨大夫诊断完说娃得了癌症");
	
		request.setAttribute("bingming", "有喜了");
		request.setAttribute("zhenduanren", "yangdaifu");
			
		/*//杨大夫说，小护士你过来，把他领取见 /Lidaifu
		RequestDispatcher xhs = request.getRequestDispatcher("Lidaifu");
		//小护士说，跟我走吧，别忘了带上你的病历
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
		
		//小护士说，跟我走吧，别忘了带上你的病历
		xhs.forward(request, response);*/
		
		response.sendRedirect(request.getContextPath() + disPath);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("我是严大夫，我拿到了病历request对象，首先可以得到你客户端的请求值");
		System.out.println("userName = " + request.getParameter("userName"));
		System.out.println("money = " + request.getParameter("money"));
		System.out.println("严大夫诊断完说娃得了癌症");
		request.setAttribute("bingming", "aizheng");
		request.setAttribute("zhenduanren", "yandaifu");
		//严大夫说，小护士你过来，把他领取见 /Lidaifu
		RequestDispatcher xhs = request.getRequestDispatcher("Lidaifu");
		//小护士说，跟我走吧，别忘了带上你的病历
		xhs.forward(request, response);
	}

}
