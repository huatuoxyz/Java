package dao;


import java.util.List;

import bean.Employee;

public interface EmployeeDao {
    public List<Employee> getAllEmployees();
    public Employee getEmployee(Integer id);
    public void update(Employee emp);
    public void insert(Employee emp);
    public void delete(Integer id);
}
