package com.guru.msscbreweryclient.web.client;

import com.guru.msscbreweryclient.web.model.BeerDto;
import com.guru.msscbreweryclient.web.model.CustomerDto;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());
         assertNotNull(beerDto);
    }

    @Test
    void testSaveNewBeer() {
        BeerDto beerDto = BeerDto.builder()
                .beerName("New Beer")
                .build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());

    }

    @Test
    void testUpdateBeer() {
        BeerDto beerDto = BeerDto.builder()
                .beerName("New Beer")
                .build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void testGetCustomerById() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("John Richard").id(UUID.randomUUID()).build();
        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("John Richard").build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}