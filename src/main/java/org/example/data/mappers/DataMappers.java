package org.example.data.mappers;

public interface DataMappers {
    <T> T map(String filename, String key, Class<T> tClass);  //returns an instance of the class
}
