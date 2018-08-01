package com.clj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clj.mapper.PositionMapper;
import com.clj.model.Position;
import com.clj.util.JsonTool;

@RestController
public class HelloWord {
	
	@Autowired
	private PositionMapper pm;
	
	@RequestMapping(value="hello")
	public Position hello(HttpServletRequest request) throws Exception {
		String ip = JsonTool.getRemoteAddr(request);
		
		Position p=JsonTool.address(ip);
		p.setIp(ip);
		pm.insert(p);
		
		return p;
	}
	
	@RequestMapping(value="sell")
	public List select() throws Exception {
		List<Position> list=pm.selectAll();
		for (Position position : list) {
			System.out.println();
		}
		return list;
	}
}
