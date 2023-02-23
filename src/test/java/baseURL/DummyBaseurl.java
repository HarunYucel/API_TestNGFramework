package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseurl {
    protected RequestSpecification specDummy;



    @Before
    public void setup(){

        specDummy = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com")
                .build();

    }

}
