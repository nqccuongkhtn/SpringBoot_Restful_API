package com.quoccuong.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quoccuong.entities.Employee;

@Repository
public class EmployeeDao {
	/*private static final Map<Integer,Employee> empMap=new HashMap<Integer,Employee>();
	static
	{
		initEmps();
	}
	private static void initEmps()
	{
		Employee emp1=new Employee(1,"E01","Test 1");
		Employee emp2=new Employee(2,"E02","Test 2");
		Employee emp3=new Employee(3,"E03","Test 3");
		empMap.put(emp1.getEmID(), emp1);
		empMap.put(emp2.getEmID(), emp2);
		empMap.put(emp3.getEmID(), emp3);
	}
	public Integer getMaxEmpId()
	{
		Set<Integer> keys=empMap.keySet();
		Integer max=0;
		for(Integer key:keys)
		{
			if(key>max)
			{
				max=key;
			}
		}
		return max;
	}
	public Employee getEmployee(Integer empId)
	{
		return empMap.get(empId);
	}
	public Employee addEmployee(Employee empForm)
	{
		Integer empId=this.getMaxEmpId()+1;
		empForm.setEmID(empId);
		empMap.put(empForm.getEmID(),empForm);
		return empForm;
	}
	public Employee updateEmployee(Employee empForm)
	{
		Employee emUpdate=this.getEmployee(empForm.getEmID());
		if(emUpdate!=null)
		{
			emUpdate.setEmpNo(empForm.getEmpNo());
			emUpdate.setEmName(empForm.getEmName());
		}
		return emUpdate;
	}
	public void deleteEmployee(Integer empId)
	{
		empMap.remove(empId);
	}
	public List<Employee> getAllEmployees()
	{
		Collection<Employee> c=empMap.values();
		List<Employee> list	=new ArrayList<Employee>();
		list.addAll(c);
		return list;
		
	}*/
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public Employee getEmployee(Integer empId)
	{
		Session session=sessionFactory.getCurrentSession();
		Employee emp=(Employee)session.get(Employee.class,empId);
		return emp;
	}
	@Transactional
	public Employee addEmployee(Employee empForm)
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(empForm);
		return empForm;
	}
	@Transactional
	public Employee updateEmployee(Employee Form)
	{
		Session session=sessionFactory.getCurrentSession();
		Employee emp=(Employee)session.get(Employee.class,Form.getEmpId());
		emp.setEmpName(Form.getEmpName());
		emp.setEmpNo(Form.getEmpNo());
		session.update(emp);
		return emp;
	}
	@Transactional
	public void deleteEmployee(Integer empId)
	{
		Session session=sessionFactory.getCurrentSession();
		Employee emp=(Employee)session.get(Employee.class,empId);
		session.delete(emp);
	}
	@Transactional
	public List<Employee> getAllEmployees()
	{
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Employee> listemp=(List<Employee>)session.createQuery("from "+Employee.class.getName()).getResultList();
		return listemp;
		
	}
	
}
