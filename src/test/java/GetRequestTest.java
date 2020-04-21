import JsonObjects.UserData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class GetRequestTest {
    String baseUrl = "https://reqres.in/api/users?page=2";

    @Test
    void RunGetRequestTest() {

        Response response = RestAssured.get(baseUrl);
        String json = response.getBody().asString();

        List<UserData> userList = Arrays.asList(from(json).getObject("data", UserData[].class));

        for (UserData userData : userList) {
            Assert.assertNotNull(userData.GetId());
            Assert.assertNotNull(userData.GetEmail());
            Assert.assertNotNull(userData.GetFirst_name());
            Assert.assertNotNull(userData.GetLast_name());
            Assert.assertNotNull(userData.GetAvatar());
        }
    }
}
