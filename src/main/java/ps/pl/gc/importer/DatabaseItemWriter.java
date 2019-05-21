package ps.pl.gc.importer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ps.pl.gc.model.Employee;
import ps.pl.gc.repositories.EmployeeRepository;

import java.util.List;

@Component
public class DatabaseItemWriter<T> implements ItemWriter<T> {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DatabaseItemWriter(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void write(List<? extends T> items) throws Exception {
        for (T item : items) {
            System.out.println(item);
            if (item instanceof Employee) {
                this.employeeRepository.saveAndFlush((Employee) item);
            }
        }
    }
}