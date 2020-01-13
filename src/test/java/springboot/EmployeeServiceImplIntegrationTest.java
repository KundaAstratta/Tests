package springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceImplIntegrationTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    // write test cases here
    @BeforeEach
    public void setUp() {
        Employee alex = new Employee("alex");

        Mockito.when(employeeRepository.findByName((alex.getName()))).thenReturn(alex);

    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound () {
        //...code here
        String name ="alex";
        Employee found = employeeService.getEmployeeByName(name);
        System.out.println("getName() "+found.getName() + " name "+name);
           Assertions.assertThat((found.getName())).isEqualTo(name) ;
    }
}