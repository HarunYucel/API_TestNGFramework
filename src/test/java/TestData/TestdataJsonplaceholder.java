package TestData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestdataJsonplaceholder {

    public int basariliStatusCode = 200;


    public JSONObject expextedbodyJson() {
        JSONObject expectedbody = new JSONObject();

        expectedbody.put("userId", 3);
        expectedbody.put("id", 22);
        expectedbody.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedbody.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");



        return expectedbody;
    }


    public HashMap requestbodyMap() {
        HashMap <String,Object> requestbodyMap = new HashMap<>();

        requestbodyMap.put("title", "Ahmet");
        requestbodyMap.put("body", "Merhaba");
        requestbodyMap.put("userId", 10.0);
        requestbodyMap.put("id",70.0);


        return requestbodyMap;
    }

}