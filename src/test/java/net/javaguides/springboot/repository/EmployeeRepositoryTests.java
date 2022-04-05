package net.javaguides.springboot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import net.javaguides.springboot.SpringbootBackendApplication;
import net.javaguides.springboot.model.Employee;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = SpringbootBackendApplication.class)
class EmployeeRepositoryTests {

	@Autowired
    private EmployeeRepository employeeRepository;

	@Test
	   public void testFindById() {
	      Employee employee = getEmployee();	     
	      employeeRepository.save(employee);
	      Employee result = employeeRepository.findById(employee.getId()).get();
	      assertEquals(employee.getId(), result.getId());	     
	   }
	   @Test
	   public void testFindAll() {
	      Employee employee = getEmployee();
	      employeeRepository.save(employee);
	      ArrayList<Employee> result = new ArrayList<>();
	      employeeRepository.findAll().forEach(e -> result.add(e));
	      assertEquals(result.size(), 18);	     
	   }
	   @Test
	   public void testSave() {
	      Employee employee = getEmployee();
	      employeeRepository.save(employee);
	      Employee found = employeeRepository.findById(employee.getId()).get();
	      assertEquals(employee.getId(), found.getId());	     
	   }
//	   @Test
//	   public void testDeleteById() {
//	      Employee employee = getEmployee();
//	      employeeRepository.save(employee);
//	      employeeRepository.deleteById(employee.getId());
//	      ArrayList<Employee> result = new ArrayList<>();
//	      employeeRepository.findAll().forEach(e -> result.add(e));
//	      assertEquals(result.size(), 0);
//	   }
	   private Employee getEmployee() {
	      Employee employee = new Employee();
	      employee.setId(1);
	      employee.setFirstName("Mad");
	      employee.setLastName("Jha");
	      employee.setEmailid("mad@gmail.com");
	      return employee;
	   }
	
	
	
}
