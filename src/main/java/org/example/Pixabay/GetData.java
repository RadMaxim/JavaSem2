package org.example.Pixabay;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class GetData {
    public static String getDataFromPixabay() throws Exception{
        URL url = new URL("https://pixabay.com/api/?key=43093131-6aaad8110d954fdeab2747c5d&category=education");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String data = bufferedReader.readLine();

        JSONObject jsonObject = new JSONObject(data);

        Object o1 = jsonObject.get("hits");
        String stringData = o1.toString();
        JSONArray jsonArray = new JSONArray(stringData);
//        jsonArray.forEach(System.out::println);
        JSONObject jsonObject1 = (JSONObject) jsonArray.get(0);
        return jsonObject1.get("userImageURL").toString();


    }
}
