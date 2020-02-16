package utils;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//TODO:: to generic
//TODO:: make workable for Lists
public class Parsers {

    public static String jsonPrettyPrinting(String json, Type typeOf) {
        Object obj = new Gson().fromJson(json, typeOf);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(obj);
    }

}
