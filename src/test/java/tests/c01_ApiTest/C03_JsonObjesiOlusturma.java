package tests.c01_ApiTest;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class C03_JsonObjesiOlusturma {

      /*

       Asagidaki JSON Objesini olusturup
        konsolda yazdirin.
         {
         "title":"Ahmet",
         "body":"Merhaba",
         "userId":1
         }

       */


    @Test
    public void jsonObje01() {

        JSONObject object = new JSONObject(); // JSONObject key ve valaue ikililerini
        // response body seklide {} yazdirir

        object.put("title", "Ahmet");
        object.put("body", "Merhaba");
        object.put("userId", 1);

        System.out.println("İlk Json objesi olusturuldu " + object);

    }


    @Test
    public void jsonObject02() {

        /*

         Asagidaki JSON Objesini olusturup konsolda yazdirin.
             {
             "firstname":"Jim",
             "additionalneeds":"Breakfast",
             "bookingdates":{
                           "checkin":"2018-01-01",
                           "checkout":"2019-01-01"
                        },

             "totalprice":111,
             "depositpaid":true,
             "lastname":"Brown"
             }

         */

        JSONObject innerObjectData = new JSONObject();

        innerObjectData.put("checkin", "2024-01-01");
        innerObjectData.put("checkout", "2025-01-01");


        JSONObject outerJsonObject = new JSONObject();

        outerJsonObject.put("firstname", "Jim");
        outerJsonObject.put("additionalneeds", "Breakfast");
        outerJsonObject.put("bookingdates", innerObjectData);
        outerJsonObject.put("totalprice", 111);
        outerJsonObject.put("depositpaid", true);
        outerJsonObject.put("lastname", "Brown");

        System.out.println("Booking Json Objesi : " + outerJsonObject);


    }


}
