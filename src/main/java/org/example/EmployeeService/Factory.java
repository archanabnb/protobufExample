package EmployeeService;

import com.employee.EmployeeDetailsRequest;
import com.google.protobuf.InvalidProtocolBufferException;
import io.restassured.response.Response;

public class Factory {

    private BuilderClass builderClass = new BuilderClass();
    private HitApi hitApi = new HitApi();

    public Response getEmployeeResponse() throws InvalidProtocolBufferException {
        EmployeeDetailsRequest employeeDetailsRequest = builderClass.getEmployeeDetailsRequest();
        return hitApi.employeeDetailsRequestHit(employeeDetailsRequest);
    }
}
