package EmployeeService;

import com.employee.EmployeeDetailsRequest;

public class BuilderClass {

    /**
     * Build Employee Details Request
     * @return Employee Details Request
     */
    public EmployeeDetailsRequest getEmployeeDetailsRequest(){
        return com.employee.EmployeeDetailsRequest.newBuilder()
                .setId(StaticValues.id)
                .setName(StaticValues.name)
                .setAge(StaticValues.age)
                .setDesignation(StaticValues.designation)
                .build();
    }
}
