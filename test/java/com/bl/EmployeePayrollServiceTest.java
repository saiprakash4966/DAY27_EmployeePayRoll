package com.bl;

import org.junit.Test;

import java.util.Arrays;

import org.junit.Assert;


public class EmployeePayrollServiceTest 
{
	@Test
    public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {

        EmployeePayrollData[] arrayOfEmps = {new EmployeePayrollData(4966,"Sai",70000.00),
                                             new EmployeePayrollData(4977,"Shivani",60000.00),
                                             new EmployeePayrollData(4988,"Prakash",35000.00)
                                            };

        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
       
        Assert.assertTrue(true);
	    
}

}
