package com.javatpoint.parser;

//import com.javatpoint.models.Teacher;
import com.javatpoint.models.Teacher;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;

public class LogBookParser {

    private Connection.Response response;

    public  void Init()
    {
        JSONObject json = new JSONObject();

        json.put("password","prokop23021991AV");
        json.put("username","prokopchuk_a@itstep.org");
        json.put("id_city",null);

        JSONObject json1 = new JSONObject();
        json1.put("LoginForm",json);

        String strin = json1.toString();

        try {
            response = Jsoup
                    .connect("https://logbook.itstep.org/auth/login")
                    .method(Connection.Method.POST)
                    .requestBody(strin)
                    .header("Content-type", "application/json")
                    .ignoreContentType(true)
                    .execute();

            System.out.println(response.parse().body());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public  List<Teacher> ParserTeachers()
//    public  void ParserTeachers()
    {
        List<Teacher> teachList = new ArrayList<>();

        try {
            Document response = Jsoup
                    .connect("https://logbook.itstep.org/auth/get-teach-list")
                    .cookies(this.response.cookies())
                    .ignoreContentType(true)
                    .post();

            System.out.println(response.body());

            String jsonString = (String.valueOf(response.body()));
            StringBuilder jsstr= new StringBuilder(jsonString);
            String jsonString1 = jsonString.replace("<body>", "");
            String jsonString2 = jsonString1.replace("</body>", "");


            JSONArray jsonObject = (JSONArray) JSONValue.parse(jsonString2);


            for (int i=0; i<jsonObject.size(); i++)
            {
                Teacher tmp = new Teacher();
                JSONObject element = (JSONObject) jsonObject.get(i);

                tmp.setFio_teach(element.get("fio_teach").toString());
                tmp.setId_teach(Integer.parseInt(element.get("id_teach").toString()));
                teachList.add(tmp);
            }

            return teachList;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return teachList;
    }

    public  void ParserInfo(Integer id_teacher)
    {

        try {

            JSONObject json = new JSONObject();
            json.put("id_user","145");
            String jsonStr = json.toString();

            response = Jsoup
                    .connect("https://logbook.itstep.org/auth/change-user")
                    .method(Connection.Method.POST)
                    .header("Content-type","application/json")
                    .requestBody(jsonStr)
                    .cookies(response.cookies())
                    .ignoreContentType(true)
                    .execute();


            Document responseInfo  = Jsoup
                    .connect("https://logbook.itstep.org/dossier/get-all-data")
                    .cookies(this.response.cookies())
                    .ignoreContentType(true)
                    .get();

            System.out.println(responseInfo.body());

        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
