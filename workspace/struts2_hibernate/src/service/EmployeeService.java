package service;

import bean.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void updateEmployee(Employee emp);
    public void deleteEmployee(Integer id);
    public Employee getEmployee(Integer id);
    public void insertEmployee(Employee emp);
}
