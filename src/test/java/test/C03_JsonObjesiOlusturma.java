package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {
    /*
     Asagidaki JSON Objesini olusturup konsolda yazdirin.

    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
     */

    @Test
    public void jsonobje(){

        JSONObject jsonObject  = new JSONObject();

        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId",1);

        System.out.println(jsonObject);



    }


}
