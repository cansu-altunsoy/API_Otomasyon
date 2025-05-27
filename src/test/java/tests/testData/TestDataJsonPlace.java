package tests.testData;

import org.json.JSONObject;

public class TestDataJsonPlace {


    public int basariliStatusCode = 200;
    public String contentType = "application/json; charset=utf-8 " ;
    public String connetionHeaderDegeri = "keep-alive";

    public JSONObject expectedDataOlusturJSON(){

        JSONObject expectedData = new JSONObject();

        expectedData.put("userid", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolorsintquoavelitexplicaboquianam");
        expectedData.put("body", "eosquietipsumipsamsuscipitaut\nsedomnisnonodio\nexpeditaearummollitiamolestiaeautatqueremsuscipit\nnamimpeditesse");

        return expectedData;
    }


    public JSONObject requestBodyOlusturJSON(){

        JSONObject requstBody = new JSONObject();

        requstBody.put("title", "Ali");
        requstBody.put("body", "Merhaba");
        requstBody.put("userId", 10);
        requstBody.put(  "id", 70);

        return requstBody;
    }




}
