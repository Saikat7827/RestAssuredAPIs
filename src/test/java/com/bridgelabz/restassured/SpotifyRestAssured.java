package com.bridgelabz.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyRestAssured {
    String token = "Bearer BQAHOcy7FvIhg-_ghgeXHFp9LrnqCAwqxABNP_awNpMgOn1fUQ7MJSV1Q8ZfS4Q5mFNBbiLWyVbTV6AXcpqfqfkDwS2qFhzqhDE9sTGj6jHfZcFHhKzuOiGF4_uyk04X6wVyANpng_-bRxO-FyZEHeaCS9tHIW3GFKr-3P7nqTuCXpR0DngRVkdFe9_RF9fH2FZJEQKrxEzb_WEE0OJslGdlY3J12WMZH7cA64LDZ1RGjwKfLDs-7lBlXcr3zhrvOYrpcjOFla-6z2WjtremtXcsBfhxLrkce2S13nhu3KELcmhF7MdAin19wkxuug";

    @Test
    public void getCurrentUserProfile_Returnsucess() {
        Response response = RestAssured.given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me");

                response.then().log().all().statusCode(200);
    }

    @Test
    public void getUserProfile_Returnsucess() {
        given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .get("https://api.spotify.com/v1/users/31n4t5lo2e64f23ukwq53uhf232y")
                .then().log().all().statusCode(200);

    }

    @Test
    public void getTrack_Returnsucess() {
        given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl")
                .then().log().all().statusCode(200);
    }

    @Test
    public void getSeveralTracks() {
        given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .get("https://api.spotify.com/v1/tracks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B")
                .then().log().all().statusCode(200);

    }

    @Test
    public void getTrackAudioFeature() {
        given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .get("https://api.spotify.com/v1/audio-features/11dFghVXANMlKmJXsNCbNl")
                .then().log().all().statusCode(200);
    }

    @Test
    public void getTrackAudioAnylysis() {
        given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .get("https://api.spotify.com/v1/audio-analysis/11dFghVXANMlKmJXsNCbNl")
                .then().log().all().statusCode(200);
    }

    @Test
    public void getShow() {
        given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ")
                .then().log().all().statusCode(200);
    }

    @Test
    public void getShowEpisodes() {
        given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ/episodes")
                .then().log().all().statusCode(200);

    }

    @Test
    public void getSeveralShows() {
        given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .get("https://api.spotify.com/v1/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ")
                .then().log().all().statusCode(200);

    }

    @Test
    public void searchForItem() {
        given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .get("https://api.spotify.com/v1/search?q=Arijit%20Singh&type=track")
                .then().log().all().statusCode(200);
    }

    @Test
    public void createPlaylist() {
        given().accept("application/json")
                .contentType("application/json")
                .header("Authorization", token)
                .body("{\"name\":\"New Playlist\",\"description\":\"New playlist description\",\"public\":false}")
                .when()
                .post("https://api.spotify.com/v1/users/31n4t5lo2e64f23ukwq53uhf232y/playlists")
                .then().log().all().statusCode(201);


    }
}





