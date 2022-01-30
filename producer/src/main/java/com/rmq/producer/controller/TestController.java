package com.rmq.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rmq.producer.model.Employee;
import com.rmq.producer.service.RMQSender;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value="/testrmq")
public class TestController {

	@Autowired
	private RMQSender rmqSender;
	
	@Autowired
	private Employee emp;
	
	@GetMapping("/publish")
	@ApiOperation(value = "Sends Message to RabbitMQ", notes = "", response = String.class)
	public String producer(@ApiParam(value = "Employee Name", required = true)@RequestParam("empname") String empName, @ApiParam(value = "Employee Id", required = true)@RequestParam("empid") String empId) {
		
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		rmqSender.send(emp);
		return "Message Sent Successful to RMQ!";
		
	}
	
}
