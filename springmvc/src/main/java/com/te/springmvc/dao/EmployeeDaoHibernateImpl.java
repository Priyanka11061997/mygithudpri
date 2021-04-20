package com.te.springmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import org.springframework.stereotype.Repository;

import com.te.springmvc.bean.EmployeeBean;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

	@Override
	public EmployeeBean authentication(int id, String pwd) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		EntityManager manager = factory.createEntityManager();

		try {
			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			
			if (bean != null) {
				if (bean.getPwd().equals(pwd)) {
					System.out.println("Login Success");
					return bean;

				} else {
					System.out.println("Invalid credentials");
					return null;
				}
			} else {
				System.out.println("User Not Found");
				return null;
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}//end of authenticate

	}

	@Override
	public EmployeeBean getEmployee(int id) {

		
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();

			EmployeeBean employeeBean = manager.find(EmployeeBean.class, id);
			if (employeeBean != null) {
				
					System.out.println("Successful");
					return employeeBean;
				} else {
					System.out.println("user not found");
					return null;
				}
			
	}

	@Override
	public boolean deleteEmpData(int id) {
		try {
			
		    EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			
			EntityTransaction transaction = manager.getTransaction();
			
			transaction.begin();
			
			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			manager.remove(bean);
			transaction.commit();
			
			if (bean != null) {
				
				System.out.println("Deleted Successfull");
				return true;
			} else {
				System.out.println("Deleted not successful");
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	// @Override
	// public List<E> getAllEmp(int id) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
