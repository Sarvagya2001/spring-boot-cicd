package com.sarvagya.employeemanagementbackend;

import org.assertj.core.api.Assertions;
import org.glassfish.jaxb.runtime.v2.schemagen.xmlschema.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sarvagya.employeemanagementbackend.model.User;
import com.sarvagya.employeemanagementbackend.repository.UserRepository;
import lombok.Builder;


@DataJpaTest
public class EmployeeRepositoryTests {
	
	@Autowired
	public UserRepository userRepository;
	
	@Test
	public void getEmployeesTest() {
		User user = userRepository.findById(4L).get();
		
		Assertions.assertThat(user.getId()).isEqualTo(4L);
	}

	
}
