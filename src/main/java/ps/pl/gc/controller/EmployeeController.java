package ps.pl.gc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ps.pl.gc.algorithms.*;
import ps.pl.gc.model.Employee;
import ps.pl.gc.service.EmployeeService;

import java.util.List;


@RestController
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/import/csv")
    private ResponseEntity<Object> importDataFromCsv() {
        Long jobId = this.employeeService.performDataImport();
        return ResponseEntity.ok(jobId);
    }

    @GetMapping("")
    private ResponseEntity<List<Employee>> getEmployees(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "elements", required = false, defaultValue = "100") int elements,
            @RequestParam(value = "sortType", required = false, defaultValue = "QUICK") Algorithm algorithm
    ) {
        System.out.println("Getting employees on page " + page + " elements: " + elements + " sorted by " + algorithm);
        List<Employee> employees = this.employeeService.getEmployeeList(page, elements, algorithm);
        System.out.println("Processed all information about employees");
        return ResponseEntity.ok(employees);
    }
}
