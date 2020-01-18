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
    public void testPostRequestNegative(String strTime) {
        Response resp = RestAssured.post("https://httpbin.org/delay/" + strTime);
        String data = resp.asString();
        if (resp.getStatusCode() == 404) {
            Assert.assertEquals(data, "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">\n" +
                    "<title>404 Not Found</title>\n" +
                    "<h1>Not Found</h1>\n" +
                    "<p>The requested URL was not found on the server.  If you entered the URL manually please check your spelling and try again.</p>\n");
        } else {
            if (resp.getStatusCode() == 500) {
                Assert.assertEquals(data, "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">\n" +
                        "<title>500 Internal Server Error</title>\n" +
                        "<h1>Internal Server Error</h1>\n" +
                        "<p>The server encountered an internal error and was unable to complete your request.  Either the server is overloaded or there is an error in the application.</p>\n");
            } else {
                //System.out.println(resp.getStatusCode());
                //System.out.println(data);
                Assert.assertNotEquals(resp.getStatusCode(), 200);
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

    @Test
    public void testsPostRequestPositive0sec() {
        testPostRequestPositive(0);
    }

    @Test
    public void testsPostRequestPositive1sec() {
        testPostRequestPositive(1);
    }

    @Test
    public void testsPostRequestPositive5sec() {
        testPostRequestPositive(05);
    }

    @Test
    public void testsPostRequestPositive9sec() {
        testPostRequestPositive(9);
    }

    @Test
    public void testsPostRequestPositive10sec() {
        testPostRequestPositive(10);
    }

    @Test
    public void testsPostRequestNegativeMinus1sec() {
        testPostRequestNegative("-1");
    }

    @Test
    public void testsPostRequestNegative11sec() {
        testPostRequestNegative("11");
    }

    @Test
    public void testsPostRequestNegativeMinus1000sec() {
        testPostRequestNegative("-1000");
    }

    @Test
    public void testsPostRequestNegative9999sec() {
        testPostRequestNegative("9999");
    }

    @Test
    public void testsPostRequestNegativeEmpty() {
        testPostRequestNegative(" ");
    }

    @Test
    public void testsPostRequestNegativeCharWithDot() {
        testPostRequestNegative("0.1");
    }

    @Test
    public void testsPostRequestNegativeCharWithPoint() {
        testPostRequestNegative("0,1");
    }

    @Test
    public void testsPostRequestNegativeCharWithSlash() {
        testPostRequestNegative("0/5");
    }

    @Test
    public void testsPostRequestNegativeLetterAndInt() {
        testPostRequestNegative("8x");
    }

    @Test
    public void testsPostRequestNegativeSpecialSymbols() {
        testPostRequestNegative("!№;%:?*()/*+-./|");
    }
}