package tests;

import com.demo.api_automation.UsersAPI;
import io.restassured.response.Response;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.TestDataGenerator;

public class UsersAPITest {

    UsersAPI usersAPI = new UsersAPI();

    // HTTP METHODS (CRUD)

    @Test
    public void testGetAllPosts() {
        Response response = usersAPI.getAllPosts();
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertTrue(response.jsonPath().getList("$").size() > 0);
    }

    @Test
    public void testGetPostById() {
        Response response = usersAPI.getPostById(1);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(1, response.jsonPath().getInt("id"));
    }

    @Test
    public void testCreatePost() {
        String body = TestDataGenerator.generatePostBody("New Title", "NewBody", 1);
        Response response = usersAPI.createPost(body);
        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("New Title", response.jsonPath().getString("title"));
    }

    @Test
    public void testUpdatePost() {
        String updatedBody = TestDataGenerator.generatePostBody("Updated Title", "Updated Body", 1);
        Response response = usersAPI.updatePost(1, updatedBody);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Updated Title", response.jsonPath().getString("title"));
    }


    @Test
    public void testDeletePost() {
        Response response = usersAPI.deletePost(1);
        Assertions.assertTrue(response.statusCode() == 200 || response.statusCode() == 204);
    }

    // NEGATIVE TESTS

    @Test
    public void testGetNonExistingPost() {
        Response response = usersAPI.getPostById(12345);
        Assertions.assertEquals(404, response.statusCode());
    }

    @Test
    public void testDeleteNonExistingPost() {
        Response response = usersAPI.deletePost(12345);
        int c = response.statusCode();
        Assertions.assertTrue(c == 404 || c == 200 || c == 204);
    }

    @Test
    public void testCreatePostWithMissingUserId() {
        Map<String, Object> body = TestDataGenerator.generatePostWithoutUserId();
        Response response = usersAPI.createPost(body);
        Assertions.assertTrue(response.statusCode() == 400 || response.statusCode() == 201);
    }

    @Test
    public void testCreatePostWithWrongFieldNames() {
        Map<String, Object> body = TestDataGenerator.generatePostWithWrongFieldNames();
        Response response = usersAPI.createPost(body);
        Assertions.assertTrue(response.statusCode() == 400 || response.statusCode() == 201);
    }

    @Test
    public void testCreatePostWithEmptyBody() {
        Response response = usersAPI.createPostWithEmptyBody();
        Assertions.assertTrue(response.statusCode() == 201 || response.statusCode() == 400);
    }

    @Test
    public void testInvalidHttpMethod() {
        Response response = usersAPI.invalidHttpMethod(1);
        int c = response.statusCode();
        Assertions.assertTrue(c == 405 || c == 200 || c == 201);
    }


    @Test
    public void testCreatePostWithInvalidContentType() {
        String body = TestDataGenerator.generateInvalidBody();
        Response response = usersAPI.createPostWithInvalidContentType(body);
        int c = response.statusCode();
        Assertions.assertTrue(c == 400 || c == 415 || c == 201);
    }
}

