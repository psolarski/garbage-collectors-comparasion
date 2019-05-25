package ps.pl.gc.algorithms;

import ps.pl.gc.model.Employee;
import java.util.ArrayList;

public class BubbleSort implements SortAlgorithm {

    public static void sort(ArrayList<Employee> employees) {
        int n = employees.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (employees.get(j).getLastName().length() < employees.get(j + 1).getLastName().length()) {
                    Employee temp = employees.get(j);
                    employees.set(j, employees.get(j + 1));
                    employees.set(j + 1, temp);
                }
    }
}
