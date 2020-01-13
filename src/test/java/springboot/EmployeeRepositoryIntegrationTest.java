package springboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    // write test cases here
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Employee alex = new Employee("alex");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByName(alex.getName());

        // then
        Assertions.assertThat(found.getName())
                .isEqualTo(alex.getName());
    }

    @Test
    public void whenFindByName_thenReturnEmployeeWithAge() {
        // given
        Employee paul = new Employee("paul",25);
        entityManager.persist(paul);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByName(paul.getName());

        // then
        Assertions.assertThat(found.getAge())
                .isEqualTo(paul.getAge());
    }


    @Test
    public void whenFindById_thenReturnEmployee() {
        // given
        Employee vinz = new Employee("vinz");
        entityManager.persist(vinz);
        entityManager.flush();

        // when
        Optional<Employee> mayBefound = employeeRepository.findById(vinz.getId());

        // then
        Assertions.assertThat(mayBefound.get().getId())
                .isEqualTo(vinz.getId());
    }

}