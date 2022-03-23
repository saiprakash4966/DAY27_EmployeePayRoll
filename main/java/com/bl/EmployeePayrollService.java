package com.bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService
{

	public enum IOService{
		CONSOLE_IO,FILE_IO,DB_IO,REST_IO
	}
	private List<EmployeePayrollData> employeePayrollList;
	public EmployeePayrollService() {
		
	}
	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList=employeePayrollList;
	}
	/**
	 * read data from console
	 * @param consoleInputReader
	 */
	public void readEmployeePayrollData(Scanner consoleInputReader) {
		System.out.println("Enter Employee ID: ");
		int id=consoleInputReader.nextInt();
		System.out.println("Enter Employee Name: ");
		String name=consoleInputReader.next();
		System.out.println("Enter Employee Salary: ");
		double salary=consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id,name,salary));
		
	}
	/**
	 * writing data to the list
	 */
	public void writeEmployeePayrollData() {

		System.out.println("\n Writing Employee Payroll to Console\n"+employeePayrollList);
	}
	
	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList=new ArrayList<EmployeePayrollData>();
		EmployeePayrollService employeePayrollService=new EmployeePayrollService(employeePayrollList);
		Scanner ConsoleInputReader=new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(ConsoleInputReader);
		employeePayrollService.writeEmployeePayrollData();
	}
	public void writeEmployeePayrollData(IOService fileIo) {
		// TODO Auto-generated method stub
		
	}
	
}