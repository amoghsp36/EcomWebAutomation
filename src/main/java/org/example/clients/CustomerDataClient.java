package org.example.clients;

import org.example.internal.CustomerBuilderLombok;

public class CustomerDataClient extends DataClient{
    public CustomerBuilderLombok getValidCustomerOfType(String key){
        String filePath=getFilePath("customer/valid_customers.json");
        return dataMappers.map(filePath,key, CustomerBuilderLombok.class);
    }
}
