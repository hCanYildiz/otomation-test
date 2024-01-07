package ApiTest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class ApiTest
{
    RequestSpecification requestSpecification;
    Response result;

    @Test
    public void ImdbId()
    {
        SearchImdb(SearchFilm()); //imdbid ile birlikte request atmak.
    }
    @Test
    public void Year(){
        //Gelen response icindeki datanın "year" alanının gelme kontrolu
        SearchImdb(SearchFilm());
        System.out.println( "Year: "+result.jsonPath().getString("Year"));
        Assertions.assertNotNull(result.jsonPath().getString("Year"));

    }
    @Test
    public void Title(){
        //Gelen response icindeki datanın "title" alanının gelme kontrolu
        SearchImdb(SearchFilm());
        System.out.println( "Title: "+result.jsonPath().getString("Title"));
        Assertions.assertNotNull(result.jsonPath().getString("Title"));

    }
    @Test
    public void Released(){
        //Gelen response icindeki datanın "realesed" alanının gelme kontrolu
        SearchImdb(SearchFilm());
        System.out.println( "Released: "+result.jsonPath().getString("Released"));
        Assertions.assertNotNull(result.jsonPath().getString("Released"));

    }
    @Test
    public void HttpCode(){
        //Gelen responsenin http status code kontrolu
        SearchImdb(SearchFilm());
        Assertions.assertEquals(200,result.statusCode());
        System.out.println("HttpStatusCode: "+result.statusCode());
    }


    public String SearchFilm()
    {
        Response response = requestName("Harry Potter").when().get("http://www.omdbapi.com/").then().extract().response();
        //response objesi Harry Potter key'ini gondeririz
        String findFilmImdbId;

        int i=0;
        while(!response.jsonPath().getString("Search["+i+"].Title").equalsIgnoreCase("Harry Potter and the Sorcerer's Stone")){
            i++;
            //ilgili filmi isaretlemek icin kullaniyoruz.
        }
        findFilmImdbId = "Search["+i+"].imdbID";
        return response.jsonPath().getString(findFilmImdbId); // ilgili filmin imdbidsini aliriz.
    }


    public void SearchImdb(String imdbID)
    {
        result = requestImdb(imdbID).when().get("http://www.omdbapi.com/").then().extract().response();
        //imdbid'sine gore request atip response aliyoruz.
    }


    public RequestSpecification requestName(String searchData)
    {
        requestSpecification = given().
                param("apikey", "d391fd7c").
                param("s", searchData);
    //apikey ve datamizi gonderiyoruz.
        return requestSpecification;
    }

    public RequestSpecification requestImdb(String id)
    {
        requestSpecification = given().
                param("apikey", "d391fd7c").
                param("i", id);
        //apikey ve datamizi gonderiyoruz.
        return requestSpecification;
    }


}