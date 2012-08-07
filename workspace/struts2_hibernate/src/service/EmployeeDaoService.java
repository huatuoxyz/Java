package service;

import java.util.List;

import bean.Employee;

import dao.EmployeeDao;
import dao.EmployeeHibernateDao;

public class EmployeeDaoService implements EmployeeService{
    private EmployeeDao dao;

    public EmployeeDaoService() {
        this.dao = new EmployeeHibernateDao();
    }

    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    public void updateEmployee(Employee emp) {
        dao.update(emp);
    }

    public void deleteEmployee(Integer id) {
        dao.delete(id);
    }

    public Employee getEmployee(Integer id) {
        return dao.getEmployee(id);
    }

    public void insertEmployee(Employee emp) {
        dao.insert(emp);
    }
}
