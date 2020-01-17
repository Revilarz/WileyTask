package API_Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class PostApiRequest {

    public void testPostRequestNegative(String strTime){
        Response resp = RestAssured.post("https://httpbin.org/delay/"+strTime);
        Assert.assertNotEquals(resp.getStatusCode(),200);
    }


    /**
     * Positive tests
     */
    public void testPostRequestPositive(int strTime){
        Response resp1 = RestAssured.post("https://httpbin.org/delay/"+strTime);
        Response resp2 = RestAssured.post("https://httpbin.org/delay/"+strTime);
        long delay = resp1.time()-resp2.time();
        long resp;
        int statusCode;
        String data;
        if (delay>0){
            statusCode = resp2.getStatusCode();
            resp = resp2.time()/1000;
            data = resp2.asString();
        }
        else{
            statusCode = resp1.getStatusCode();
            resp = resp1.time()/1000;
            data = resp1.asString();
        }
        //If all integer is Ok than this variant
        /*if (strTime<0){
            Assert.assertEquals(resp,0);
        }
        else{
            if (strTime>10){
                Assert.assertEquals(resp,10);
            }
            else {
                Assert.assertEquals(resp,strTime);
            }
        }*/
        System.out.println(data);
        Assert.assertEquals(resp,strTime);
        Assert.assertEquals(statusCode,200);
    }

    @Test
    public void testsPostRequestPositive0sec(){
        testPostRequestPositive(0);
    }

    @Test
    public void testsPostRequestPositive1sec(){
        testPostRequestPositive(1);
    }

    @Test
    public void testsPostRequestPositive5sec(){
        testPostRequestPositive(05);
    }

    @Test
    public void testsPostRequestPositive9sec(){
        testPostRequestPositive(9);
    }

    @Test
    public void testsPostRequestPositive10sec(){
        testPostRequestPositive(10);
    }

    @Test
    public void testsPostRequestNegativeMinus1sec(){
        testPostRequestNegative("-1");
    }

    @Test
    public void testsPostRequestNegative11sec(){
        testPostRequestNegative("11");
    }

    @Test
    public void testsPostRequestNegativeMinus1000sec(){
        testPostRequestNegative("-1000");
    }

    @Test
    public void testsPostRequestNegative9999sec(){
        testPostRequestNegative("9999");
    }

    @Test
    public void testsPostRequestNegativeEmpty(){
        testPostRequestNegative(" ");
    }

    @Test
    public void testsPostRequestNegativeCharWithDot(){
        testPostRequestNegative("0.1");
    }

    @Test
    public void testsPostRequestNegativeCharWithPoint(){
        testPostRequestNegative("0,1");
    }

    @Test
    public void testsPostRequestNegativeCharWithSlash(){
        testPostRequestNegative("0/5");
    }

    @Test
    public void testsPostRequestNegativeLetterAndInt(){
        testPostRequestNegative("8x");
    }

    @Test
    public void testsPostRequestNegativeSpecialSymbols(){
        testPostRequestNegative("!№;%:?*()/*+-./|");
    }
}
