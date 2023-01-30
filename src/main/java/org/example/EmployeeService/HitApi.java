package EmployeeService;

import com.employee.EmployeeDetailsRequest;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HitApi {

    public Response employeeDetailsRequestHit(EmployeeDetailsRequest employeeDetailsRequest) throws InvalidProtocolBufferException {
        String payload = JsonFormat.printer().preservingProtoFieldNames().includingDefaultValueFields().print(employeeDetailsRequest);
        return given().header("authorization", "Test")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .and()
                .body(payload)
                .when()
                .post("http://localhost:8080/testEndpoint");
    }
}
