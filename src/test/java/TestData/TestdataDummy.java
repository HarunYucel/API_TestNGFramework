package TestData;

import java.util.HashMap;

public class TestdataDummy {

    public int basarilisatatuskod = 200;
    public String contentType    = "application/json";

public HashMap evpectedMapOlustur(){

    HashMap<String,Object>innerbodyMap=new HashMap<>();

    innerbodyMap.put("id",3.0);
    innerbodyMap.put("employee_name","Ashton Cox");
    innerbodyMap.put("employee_salary",86000.0);
    innerbodyMap.put("employee_age",66.0);
    innerbodyMap.put("profile_image","");

    HashMap<String,Object>expectedmap=new HashMap<>();

    expectedmap.put("status","success");
    expectedmap.put("data",innerbodyMap);
    expectedmap.put("message","Successfully! Record has been fetched.");



return expectedmap;

}








}
