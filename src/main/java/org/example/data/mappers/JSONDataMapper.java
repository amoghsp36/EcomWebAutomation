package org.example.data.mappers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import org.example.internal.CustomerBuilderLombok;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Objects;

public class JSONDataMapper implements DataMappers{
    @Override
    public <T> T map(String file, String key, Class<T> tClass){
        Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try{
            Map<String, LinkedTreeMap> jsonMap = gson.fromJson(new FileReader(file), Map.class);
            LinkedTreeMap jsonElement = jsonMap.get(key);
            if(Objects.isNull(jsonElement)) throw new FileNotFoundException();
            return gson.fromJson(jsonElement.toString(), tClass);
        }catch (FileNotFoundException e){
            throw new RuntimeException(String.format("Failed to find data for key %s in file %s or filepath %s itself is wrong", key, file, file));
        }
    }
}
