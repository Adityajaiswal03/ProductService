package dev.aditya.productservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductServiceApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void TestisOnePlusOneisTwo(){
        int i=2;
//        assert(i==2);
        assertEquals(2,i,"The Value isn't 2,So the Test Case Failed");
    }


}
