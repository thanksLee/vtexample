package com.vitamin.ex_pcweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {
	private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);
	
	@RequestMapping("/hello.do")
	public String indexUrl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/hello";
	}

}
