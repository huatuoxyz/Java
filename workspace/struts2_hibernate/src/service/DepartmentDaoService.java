package service;

import java.util.*;

import bean.Department;

import dao.DepartmentDao;
import dao.DepartmentHibernateDao;

public class DepartmentDaoService implements DepartmentService {
    private DepartmentDao dao;

    public DepartmentDaoService() {
        this.dao = new DepartmentHibernateDao();
    }

    public List<Department> getAllDepartments() {
        return dao.getAllDepartments();
    }
}
