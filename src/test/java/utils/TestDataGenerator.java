package utils;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class TestDataGenerator {

    public static String generatePostBody(String title, String body, int userId) {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("body", body);
        json.put("userId", userId);
        return json.toString();
    }

    public static String generateInvalidBody() {
        return "This is not a JSON";
    }

    public static Map<String, Object> generatePostWithoutUserId() {
        Map<String, Object> mp = new HashMap<>();
        mp.put("title", "No userId provided");
        mp.put("body", "This post does not have userId");
        return mp;
    }

    public static Map<String, Object> generatePostWithWrongFieldNames() {
        Map<String, Object> mp = new HashMap<>();
        mp.put("title", "Wrong Key Example");
        mp.put("body", "Using a wrong key instead of userId");
        mp.put("user_name", 1); //Here it should be user_Id not user_name
        return mp;
    }
}
