package Week1HW.q7;

import java.util.Arrays;

/**
 * Functionality: Demonstrates the sorting of Employees by name, department, then age in that order.
 */
public class EmployeeSortTester {
    public static void main(String[] args) {
        Employee employeeArray[] = new Employee[2];
        employeeArray[0] = new Employee("Tom", "Sales", 23);
        employeeArray[1] = new Employee("Tom", "Sales", 19);
        System.out.println("Before sort: " + Arrays.toString(employeeArray));
        if(employeeArray[0].compareTo(employeeArray[1]) > 0){ //if the first employee is less than the second, switch
            Employee temp = employeeArray[0];//standard three-variable swap
            employeeArray[0] = employeeArray[1];
            employeeArray[1] = temp;
        }
        System.out.println("After sort: " + Arrays.toString(employeeArray));
    }
}
