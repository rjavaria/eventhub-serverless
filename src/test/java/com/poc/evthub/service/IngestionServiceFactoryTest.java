package com.poc.evthub.service;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngestionServiceFactoryTest {
    @Autowired
    private IngestionServiceFactory ingestionServiceFactory;


    @Test
    public void test() {
        System.out.println(ingestionServiceFactory);
        Assert.assertThat(ingestionServiceFactory,
                Matchers.instanceOf(IngestionServiceFactory.class));
    }
}
