import JsonObjects.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequestTest {
    String baseUrl = "https://reqres.in/api/users";

    @Test
    public void RunPostRequestTest() {

        String UserName = "morpheus";
        String UserJob = "leader";

        User morpheusUser = new User(UserName, UserJob);
        Response response = given().contentType("application/json").body(morpheusUser).when().post(baseUrl);

        User userForResponse = response.as(User.class);

        Assert.assertEquals(userForResponse.getName(), UserName);
        Assert.assertEquals(userForResponse.getJob(), UserJob);
    }

}
