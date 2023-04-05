package com.web.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @Controller + @ResponseBody
public class BasicControlleer {

	
	@GetMapping("/view/test")
	public Object view() {
		
		List<String> strList = new ArrayList<>();
		
		strList.add("a");
		strList.add("b");
		strList.add("c");
		strList.add("d");
	
		return strList;
	}
	
}
