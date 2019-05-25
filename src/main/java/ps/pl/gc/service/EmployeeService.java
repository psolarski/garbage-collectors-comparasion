package ps.pl.gc.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import ps.pl.gc.algorithms.Algorithm;
import ps.pl.gc.algorithms.BubbleSort;
import ps.pl.gc.algorithms.QuickSort;
import ps.pl.gc.algorithms.SortAlgorithm;
import ps.pl.gc.model.Employee;
import ps.pl.gc.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequestScope
public class EmployeeService {


    private final JobLauncher jobLauncher;
    private final Job job;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(Job job, JobLauncher jobLauncher, EmployeeRepository employeeRepository) {
        this.job = job;
        this.jobLauncher = jobLauncher;
        this.employeeRepository = employeeRepository;
    }

    public Long performDataImport() {
        try {
            JobParameters params = new JobParametersBuilder()
                    .addString("JobID", String.valueOf(System.currentTimeMillis()))
                    .toJobParameters();
            return jobLauncher.run(job, params).getJobId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> getEmployeeList(
            int page,
            int elements,
            Algorithm algorithm
    ) {
        Pageable pageable = PageRequest.of(page, elements);
        ArrayList<Employee> employees = new ArrayList<>(
                this.employeeRepository.findAll(pageable).getContent()
        );
        switch (algorithm) {
            case QUICK: {
                QuickSort.sort(employees);
                break;
            }
            case BUBBLE: {
                BubbleSort.sort(employees);
                break;
            }
        }
        employees.forEach(it -> {
            it.setFirstName(it.getFirstName() + " GC!");
        });
        return employees;
    }

    public Employee createEmployee(Employee employee) {
        return this.employeeRepository.saveAndFlush(employee);
    }
}
