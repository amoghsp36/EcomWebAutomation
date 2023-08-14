package org.example.internal;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBuilderLombok {
    @Expose
    private String email;
    @Expose
    private String password;
    private String firstName;
    private String lastName;
    private Address shippingAddress;
    private PaymentMode paymentMode;
    //private Card cardDetails;
    private Address billingAddress;

    public CustomerBuilderLombok init(){

        Faker faker=new Faker();
        return this.toBuilder().email(faker.internet()
                .emailAddress())
                .password(faker.internet().password())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName()).shippingAddress(faker.address()).build();
    }
}
