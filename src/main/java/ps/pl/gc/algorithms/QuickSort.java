package ps.pl.gc.algorithms;

import ps.pl.gc.model.Employee;

import java.util.ArrayList;

public class QuickSort implements SortAlgorithm {
    private static ArrayList<Employee> employees;

    public static void sort(ArrayList<Employee> values) {
        if (values == null || values.size() == 0) {
            return;
        }
        employees = values;
        int number = values.size();
        quicksort(0, number - 1);

    }

    private static void quicksort(int low, int high) {
        int i = low, j = high;
        Employee pivot = employees.get(low + (high - low) / 2);

        while (i <= j) {
            while (employees.get(i).getLastName().length() > pivot.getLastName().length()) {
                i++;
            }
            while (employees.get(j).getLastName().length() < pivot.getLastName().length()) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private static void exchange(int i, int j) {
        Employee temp = employees.get(i);

        employees.set(i, employees.get(j));
        employees.set(j, temp);
    }
} 