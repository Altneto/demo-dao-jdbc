package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== TEST 3: department findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: department insert ====");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserido! Novo id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 5: department update ====");
		department = departmentDao.findById(3);
		department.setName("Physiotherapy");
		departmentDao.update(department);
		System.out.println("Atualização concluida");
		
		
		System.out.println("\n=== TEST 6: department delete ====");
		System.out.print("Entre com o Id para deletar: ");
		int id = scanner.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Id deletado");
		
		scanner.close();

	}

}
