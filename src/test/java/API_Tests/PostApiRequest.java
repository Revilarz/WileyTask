package API_Tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class PostApiRequest {

    /**
     * Negative tests
     */
    public void testPostRequestNegative(String strTime, int intStatusCode) {
        Response resp = RestAssured.post("https://httpbin.org/delay/" + strTime);
        String data = resp.asString();
        if (resp.getStatusCode() == 404) {
            Assert.assertEquals(resp.getStatusCode(), intStatusCode);
            Assert.assertEquals(data, "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">\n" +
                    "<title>404 Not Found</title>\n" +
                    "<h1>Not Found</h1>\n" +
                    "<p>The requested URL was not found on the server.  If you entered the URL manually please check your spelling and try again.</p>\n");
        } else {
            if (resp.getStatusCode() == 500) {
                Assert.assertEquals(resp.getStatusCode(), intStatusCode);
                Assert.assertEquals(data, "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">\n" +
                        "<title>500 Internal Server Error</title>\n" +
                        "<h1>Internal Server Error</h1>\n" +
                        "<p>The server encountered an internal error and was unable to complete your request.  Either the server is overloaded or there is an error in the application.</p>\n");
            } else {
                //System.out.println(resp.getStatusCode());
                //System.out.println(data);
                Assert.assertEquals(resp.getStatusCode(), intStatusCode);
            }
        }

    }

    /**
     * Positive tests
     */
    public void testPostRequestPositive(int strTime) {
        RestAssured.baseURI = "https://httpbin.org/delay";
        Response resp1 = RestAssured.given()
                .when()
                .get("/" + strTime);
        Response resp2 = RestAssured.given()
                .when()
                .get("/" + strTime);
        long delay = resp1.time() - resp2.time();

        if (delay > 0) {
            JsonPath jsonPathValidator = resp2.jsonPath();
            Assert.assertEquals(resp2.getStatusCode(), 200);
            Assert.assertEquals(resp2.time() / 1000, strTime);
            Assert.assertEquals(jsonPathValidator.get("args") + "", "{}");
            Assert.assertEquals(jsonPathValidator.get("data") + "", "");
            Assert.assertEquals(jsonPathValidator.get("files") + "", "{}");
            Assert.assertEquals(jsonPathValidator.get("form") + "", "{}");
            Assert.assertEquals(jsonPathValidator.get("headers") + "", "{Accept=*/*, Accept-Encoding=gzip,deflate, Host=httpbin.org, User-Agent=Apache-HttpClient/4.5.3 (Java/12.0.2)}");
            Assert.assertEquals(jsonPathValidator.get("origin") + "", "128.68.36.17, 128.68.36.17");
            Assert.assertEquals(jsonPathValidator.get("url") + "", "https://httpbin.org/delay/" + strTime);
        } else {
            JsonPath jsonPathValidator = resp1.jsonPath();
            Assert.assertEquals(resp1.getStatusCode(), 200);
            Assert.assertEquals(resp1.time() / 1000, strTime);
            Assert.assertEquals(jsonPathValidator.get("args") + "", "{}");
            Assert.assertEquals(jsonPathValidator.get("data") + "", "");
            Assert.assertEquals(jsonPathValidator.get("files") + "", "{}");
            Assert.assertEquals(jsonPathValidator.get("form") + "", "{}");
            Assert.assertEquals(jsonPathValidator.get("headers") + "", "{Accept=*/*, Accept-Encoding=gzip,deflate, Host=httpbin.org, User-Agent=Apache-HttpClient/4.5.3 (Java/12.0.2)}");
            Assert.assertEquals(jsonPathValidator.get("origin") + "", "128.68.36.17, 128.68.36.17");
            Assert.assertEquals(jsonPathValidator.get("url") + "", "https://httpbin.org/delay/" + strTime);
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
    }

    //positive data, should be OK like Status Code - 2xx: Success (успешно)
    @Test
    public void testsPostRequestPositive0sec() {
        testPostRequestPositive(0);
    }

    //positive data, should be OK like Status Code - 2xx: Success (успешно)
    @Test
    public void testsPostRequestPositive1sec() {
        testPostRequestPositive(1);
    }

    //positive data, should be OK like Status Code - 2xx: Success (успешно)
    @Test
    public void testsPostRequestPositive5sec() {
        testPostRequestPositive(05);
    }

    //positive data, should be OK like Status Code - 2xx: Success (успешно)
    @Test
    public void testsPostRequestPositive9sec() {
        testPostRequestPositive(9);
    }

    //positive data, should be OK like Status Code - 2xx: Success (успешно)
    @Test
    public void testsPostRequestPositive10sec() {
        testPostRequestPositive(10);
    }

    //negative data -1, should be error like Status Code = 4xx: Client Error (ошибка клиента)
    //if Status Code = 200 is OK< then change 400 on 200
    @Test
    public void testsPostRequestNegativeMinus1sec() {
        testPostRequestNegative("-1",400);
    }

    //negative data 11, should be error like Status Code = 4xx: Client Error (ошибка клиента)
    //if Status Code = 200 is OK< then change 400 on 200
    @Test
    public void testsPostRequestNegative11sec() {
        testPostRequestNegative("11",400);
    }

    //negative data -1, should be error like Status Code = 4xx: Client Error (ошибка клиента)
    //if Status Code = 200 is OK< then change 400 on 200
    @Test
    public void testsPostRequestNegativeMinus1000sec() {
        testPostRequestNegative("-1000",400);
    }

    //negative data -1, should be error like Status Code = 4xx: Client Error (ошибка клиента)
    //if Status Code = 200 is OK< then change 400 on 200
    @Test
    public void testsPostRequestNegative9999sec() {
        testPostRequestNegative("9999",400);
    }

    //negative data - empty request, should be error like Status Code = 4xx: Client Error (ошибка клиента)
    @Test
    public void testsPostRequestNegativeEmpty() {
        testPostRequestNegative(" ",404);
    }

    //negative data - empty request, should be error like Status Code = 4xx: Client Error (ошибка клиента) (in this situation i think should be 415 Unsupported Media Type)
    //if Status Code = 200 is OK< then change 415 on 200
    @Test
    public void testsPostRequestNegativeCharWithDot() {
        testPostRequestNegative("0.1",415);
    }

    //negative data - empty request, should be error like Status Code = 4xx: Client Error (ошибка клиента) or 5xx: Server Error (ошибка сервера)
    @Test
    public void testsPostRequestNegativeCharWithPoint() {
        testPostRequestNegative("0,1",500);
    }

    //negative data - 0/5, should be error like Status Code = 4xx: Client Error (ошибка клиента)
    @Test
    public void testsPostRequestNegativeCharWithSlash() {
        testPostRequestNegative("0/5",404);
    }

    //negative data - 8x, should be error like Status Code = 4xx: Client Error (ошибка клиента) or 5xx: Server Error (ошибка сервера)
    @Test
    public void testsPostRequestNegativeLetterAndInt() {
        testPostRequestNegative("8x",500);
    }

    //negative data - special symbols, should be error like Status Code = 4xx: Client Error (ошибка клиента)
    @Test
    public void testsPostRequestNegativeSpecialSymbols() {
        testPostRequestNegative("!№;%:?*()/*+-./|",500);
    }
}