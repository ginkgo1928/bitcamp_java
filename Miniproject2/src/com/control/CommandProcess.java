package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess  {
	//추상-->부모 생성
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable;

}
