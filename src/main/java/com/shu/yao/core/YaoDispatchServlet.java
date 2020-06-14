package com.shu.yao.core;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shu.yao.entity.Office;


public class YaoDispatchServlet extends HttpServlet{
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res){
	    try{
	        PrintWriter pw = res.getWriter();
	        pw.println("hello, Http");
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res){
	    this.doGet(req,res);    
	}

	@Override
	public final void init() throws ServletException {	
		
		System.out.println("------------我启动了。。。。。。。。。");
		
		initController();
	}

	private void initController() {
		String path = this.getClass().getResource("/").getPath();
		
		  Class c;
		try {
			c = Class.forName("com.shu.yao.entity.Office");
			Office o =(Office) c.newInstance();
			o.setAddress("3333jfdioas");
			 System.out.println("000"+o.getAddress()+"999");
			 
			InputStream in = Office.class.getClassLoader().getResourceAsStream("db.properties");
			Properties pros = new Properties();
			pros.load(in);
			String dbname = pros.getProperty("dbname");
			String user = pros.getProperty("user");
			System.out.println("dbname："+dbname+" user:"+user);
			
			
			String paths = Office.class.getClassLoader().getResource("db.properties").getPath();
			FileInputStream fin = new FileInputStream(paths);
			Properties pro2 = new Properties();
			pro2.load(fin);
			String dbname1 = pro2.getProperty("dbname");
			String user1 = pro2.getProperty("user");
			System.out.println("dbname："+dbname1+" user:"+user1);
			
			FileInputStream fins = (FileInputStream) this.getServletContext().getResourceAsStream("db.properties");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
		
		
	}
	
	
}
