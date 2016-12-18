/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.employee;

import java.util.ArrayList;

/**
 *
 * @author ayush
 */
public class EmployeeDirectory {
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

       public Employee createEmployee(String name) {
        Employee employee = new Employee();
        employee.setName(name);
        employeeList.add(employee);
        return employee;
    }

//    public Consumer createConsumer(String name, String address) {
//        Consumer consumer = new Consumer();
//        consumer.setName(name);
//        consumer.setAddress(address);
//        employeeList.add(consumer);
//        return consumer;
//    }
//
//    public void removeConsumer(Consumer consumer) {
//        employeeList.remove(consumer);
//    }
//
//    public boolean updateConsumer(Consumer c) {
//        if (employeeList.contains(c)) {
//            int elementIndex = employeeList.indexOf(c);
//            employeeList.set(elementIndex, c);
//            return true;
//        } else {
//            return false;
//        }
//    }
}
