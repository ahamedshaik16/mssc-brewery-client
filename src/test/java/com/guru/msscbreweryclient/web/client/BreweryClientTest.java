package com.guru.msscbreweryclient.web.client;

import com.guru.msscbreweryclient.web.model.BeerDto;
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
}