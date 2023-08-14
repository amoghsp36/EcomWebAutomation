package org.example.clients;

import org.example.data.mappers.DataMappers;
import org.example.data.mappers.JSONDataMapper;

import java.util.Objects;

public abstract class DataClient {
    protected DataMappers dataMappers;
    public DataClient(){
        dataMappers=new JSONDataMapper();
    }
    protected String getFilePath(String relativePath){
        return Objects.requireNonNull(this.getClass().getClassLoader()
                .getResource(String.format("data_sets/%s",relativePath)))
                .getPath();
    }
}
