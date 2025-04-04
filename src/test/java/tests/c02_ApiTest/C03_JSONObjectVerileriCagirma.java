package tests.c02_ApiTest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class C03_JSONObjectVerileriCagirma {


    /*
             {
        "firstName":"John",
         "lastName":"doe",
         "age": 30,
         "address":{
            "streetAddress":"Kurtulus cad.",
           "city":"Ankara",
            "postalCode":"06100"
             },


         "phoneNumbers":[
                        {
                         "number":"532-555 55 55",
                         "type":"İphone"
                    },
                  {
                 "number":"0312-123 4567",
                 "type":"home "
             }
            ]
       }

     */


    @Test
    public void jsonPath01() {

        JSONObject cellPhone = new JSONObject();

        cellPhone.put("type", "İphone");
        cellPhone.put("number", "532-555 55 55");


        JSONObject homePhone = new JSONObject();

        homePhone.put("type", "home ");
        homePhone.put("number", "0312-123 4567");

        JSONArray phoneNumbers = new JSONArray();

        phoneNumbers.put(0, cellPhone);
        phoneNumbers.put(1, homePhone);


        JSONObject address = new JSONObject();

        address.put("streetAddress", "Kurtulus cad.");
        address.put("city", "Ankara");
        address.put("postalCode", "06100");


        JSONObject kisiBilgileri = new JSONObject();

        kisiBilgileri.put("firstName", "John");
        kisiBilgileri.put("lastName", "doe");
        kisiBilgileri.put("age", 30);
        kisiBilgileri.put("address", address);
        kisiBilgileri.put("phoneNumbers", phoneNumbers);

        System.out.println("Kisi Bilgileri : " + kisiBilgileri);


        System.out.println("Isim :" +kisiBilgileri.get("firstName"));
        System.out.println("Soyisim :" +kisiBilgileri.get("lastName"));
        System.out.println("Yaş :" +kisiBilgileri.get("age"));


        System.out.println("Cadde adi :" +kisiBilgileri.getJSONObject("address").get("streetAddress"));
        System.out.println("Şehir :" +kisiBilgileri.getJSONObject("address").get("city"));
        System.out.println("PostaKodu :" +kisiBilgileri.getJSONObject("address").get("postalCode"));

        System.out.println("Telefon No :" + kisiBilgileri.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        System.out.println("Telefon Turu :" + kisiBilgileri.getJSONArray("phoneNumbers").getJSONObject(1).get("type"));






    }


}
