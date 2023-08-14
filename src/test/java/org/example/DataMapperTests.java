package org.example;

import org.example.clients.CustomerDataClient;
import org.example.internal.CustomerBuilderLombok;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataMapperTests {
    @Test
    public void verifyCustomerWithActiveItemsInCartIsSourcesCorrectly(){
        CustomerDataClient customerDataClient = new CustomerDataClient();
        CustomerBuilderLombok customerWithActiveItemsInCart = customerDataClient.getValidCustomerOfType("customerWithActiveItemsInCart");

        Assert.assertEquals(customerWithActiveItemsInCart.getEmail(),"abc@xyz.com");
        Assert.assertEquals(customerWithActiveItemsInCart.getPassword(),"abc1234");
    }

    @Test
    public void verifyCustomerWithSpringSaleCouponIsSourcesCorrectly(){
        CustomerDataClient customerDataClient=new CustomerDataClient();
        CustomerBuilderLombok customerWithSpringSaleCoupon = customerDataClient.getValidCustomerOfType("customerWithSpringSaleCoupon");

        Assert.assertEquals(customerWithSpringSaleCoupon.getEmail(),"def@ijk.com");
        Assert.assertEquals(customerWithSpringSaleCoupon.getPassword(),"def1234");
    }
}
