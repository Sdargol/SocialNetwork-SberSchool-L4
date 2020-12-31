package org.sdargol.sn.bot;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

public class StorageAnswers {
    Map<String,String> answers;

    // "/answer.json"
    public StorageAnswers(String path){
        try (Reader reader = new InputStreamReader(this.getClass().getResourceAsStream(path))) {
            Type type = new TypeToken<Map<String, String>>(){}.getType();
            Gson g = new Gson();
            answers = g.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String,String> getAnswersMap(){
        return answers;
    }
}
