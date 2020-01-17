package API_Tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetApiRequest {

    /**
     *4 suggestions contain attribute "term" : value starting with the preformatted highlighted word java inside like <span class=\"search-highlight\">java</span>
     */
    @Test
    public void testFirstApiTestFirstPart() {
        RestAssured.baseURI = "https://www.wiley.com/en-us/search/autocomplete";
        Response response = null;
        try {
            response = RestAssured.given()
                    .when()
                    .get("/comp_00001H9J?term=Java");
        } catch (Exception e) {
            e.printStackTrace();
        }
        JsonPath jsonPathVal = response.jsonPath();
        String REGEX =
                "(term.*?search-highlight.*?java)";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(" " + jsonPathVal.get("suggestions"));
        int count = 0;
        while (m.find()) {
            count++;
        }
        //System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
        //System.out.println(count);
        Assert.assertEquals(count,4);
    }

    /**
     * 4 products contain attribute “name”: value includes the preformatted highlighted word Java inside like  <span class=\"search-highlight\">Java</span>
     */
    @Test
    public void testFirstApiTestSecondPart() {
        RestAssured.baseURI = "https://www.wiley.com/en-us/search/autocomplete";
        Response response = null;
        try {
            response = RestAssured.given()
                    .when()
                    .get("/comp_00001H9J?term=Java");
        } catch (Exception e) {
            e.printStackTrace();
        }
        JsonPath jsonPathVal = response.jsonPath();
        String REGEX =
                "(name.*?search-highlight.*?Java)";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(" " + jsonPathVal.get("products"));
        int count = 0;
        while (m.find()) {
            count++;
        }
        //System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
        //System.out.println(count);
        Assert.assertTrue(count ==4);
    }

    /**
     * 4 pages with attribute “title”: value includes word Wiley
     */
    @Test
    public void testFirstApiTestThirdPart() {
        Response resp = RestAssured.get("https://www.wiley.com/en-us/search/autocomplete/comp_00001H9J?term=Java");
        String data = resp.asString();
        String REGEX =
                "(title.*?Wiley)";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(data);
        int count = 0;
        while (m.find()) {
            count++;
        }
        //System.out.println(resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(),200);
        //System.out.println(count);
        Assert.assertEquals(count,4);
    }

    @Test
    public void testApiLetterB(){

        //make get response for getting all images without reiteration
        Response resp = RestAssured.get("https://www.wiley.com/en-us/search/autocomplete/comp_00001H9J?term=Java");
        String data = resp.asString();
        String REGEX =
                "(\"url\":\")(https:..media.wiley.*?jpg)";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(data);
        Set<String> images = new HashSet<String>();
        while (m.find()) {
            images.add(m.group(2));
        }

        //check that alright)
        //System.out.println(images);

        //open images in browser in headless mode for getting size
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        Iterator<String> iterator = images.iterator();
        while(iterator.hasNext()){
            driver.get(iterator.next());
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/img")).getSize().width,300);
            //System.out.println(driver.findElement(By.xpath("/html/body/img")).getSize().width);
        }
    }

}