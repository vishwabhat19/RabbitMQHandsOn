package com.rmq.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rmq.producer.model.Employee;
import com.rmq.producer.service.RMQSender;

@RestController
@RequestMapping(value="/testrmq")
public class TestController {

	@Autowired
	private RMQSender rmqSender;
	
	@Autowired
	private Employee emp;
	
	@GetMapping("/publish")
	public String producer(@RequestParam("empname") String empName,@RequestParam("empid") String empId) {
		
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		rmqSender.send(emp);
		return "Message Sent Successful to RMQ!";
		
	}
	
}
