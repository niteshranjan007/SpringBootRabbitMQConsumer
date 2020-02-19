package com.javainuse.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.entity.EmployeeEntity;
import com.javainuse.model.Employee;
import com.javainuse.repository.EmployeeRepository;

@Service
public class RabbitMQConsumer {
	
	@Autowired
	EmployeeRepository empRepo;

	@RabbitListener(queues = "${javainuse.rabbitmq.queue}")
	public void recievedMessage(Employee employee) {
		System.out.println("Recieved Message From RabbitMQ: " + employee);
		EmployeeEntity em = new EmployeeEntity();
		em.setEmpId(employee.getEmpId());
		em.setEmpName(employee.getEmpName());
		empRepo.save(em);
		System.out.println("Data Inserted");
	}
}