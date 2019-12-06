package com.control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.management.InstanceNotFoundException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.proxy.annotation.Post;

public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> map = new HashMap<String, Object>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 환경설정
		String propertyConfig = config.getInitParameter("propertyConfig");
		System.out.println("propertyConfig = " + propertyConfig + "\n");

		// 외부에서 환경설정한 파일을 보관한다-->Properties
		FileInputStream fin = null;
		Properties properties = new Properties();

		try {
			fin = new FileInputStream(propertyConfig);
			properties.load(fin);
			System.out.println("Properties=" + properties);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		} finally {
			try {
				fin.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		// properties의 내용을 set 보관하고 Iterator 생성
		Iterator it = properties.keySet().iterator();
		while(it.hasNext()) {
		String key= (String) it.next(); //보관
		System.out.println("key="+key);
		//내가 key값 줄테니까 클래스 이름 줘
		String className=properties.getProperty(key);
		System.out.println("className="+className);
		
		try {
			Class  classType=Class.forName(className);
			Object ob=classType.newInstance();
			System.out.println("ob="+ob);
			map.put(key, ob);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (InstantiationException e) {
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		System.out.println();
	}//while
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws SecurityException, IOException {
		if (request.getMethod().equals("POST")) { // post만 한글 처리
			request.setCharacterEncoding("UTF-8");
		}
		String category=request.getServletPath();
		System.out.println("category="+category);
		
		CommandProcess commandProcess=(CommandProcess)map.get(category);
		System.out.println("commandProcess="+commandProcess);
		
		String view=null;
		try {
			view=commandProcess.requestPro(request, response);//호출
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
}
