import EmployeeService.AssertionsClass;
import EmployeeService.Factory;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.google.protobuf.InvalidProtocolBufferException;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class sampleAPITest {
    WireMockServer wmserver;
    private Factory factory = new Factory();
    private AssertionsClass assertion = new AssertionsClass();

    @BeforeClass
    public void initializeWiremock() {
        wmserver = new WireMockServer(8080);
        wmserver.start();
        createStub();
    }

    private void createStub() {
        wmserver.stubFor(post(urlEqualTo("/testEndpoint"))
                .willReturn(
                        aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withStatusMessage("Test Complete!")
                                .withStatus(200)
                )
        );
    }


    @Test
    public void sampleTest() throws InvalidProtocolBufferException {
        Response employeeResponse = factory.getEmployeeResponse();
        assertion.assertStatusCode(employeeResponse.statusCode(),200);
        System.out.println("Test Success");
    }

    @AfterClass
    public void closeWireMock() {
        wmserver.stop();
    }
}
