# WileyTask
````
test task from Wiley Co.
````

##Getting Started
```
These instructions will get you a copy of the project up and running on your
local machine for testing purposes. 
```
###Prerequisites
```
What things you need for runing this code:
- clone this project on your PC
- open IDEA and open project
```
##Running the tests
````
For running UI tests:
1. Open folder WileyTask/src/test/java/UI_Tests/Tests
2. Select all (4) classes in folder UI and Running:
    2.1. FirstTest shoud faild, because under resources sub-header 12 items, but by task needs 11.
    2.2. All other tests (SecondTest,ThirdTest,ForthTest) should be OK.
For running API tests:
1.Open folder WileyTask/src/test/java/API_Tests
2.Select all (2) classes in folder API_Tests and Running:
    2.1. testFirstApiTestSecondPart - should faild because more then  4 products contain attribute 
    “name”: value includes the preformatted highlighted word Java inside like  
    <span class=\"search-highlight\">Java</span>.
    2.2. Some tests in PostApiRequest faild because some tests data make normal post request and 
    get status 200.
````
##Built With
````
- [selenium-java](https://selenium.dev/)
- [junit](https://junit.org/junit4/)
- [rest-assured](http://rest-assured.io/)
- [json-simple](https://www.json.org/json-ru.html)