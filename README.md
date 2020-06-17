**** WELCOME TO MOVIE REVIEW SYSTEM *****

This is a Spring Boot Web Application with REST endpoints and written in Java 8.
Spring Version used ---> 2.3.1.Version

Functions(Business Logic) :-

The application basically has 3 main functions :-

1. Add a movie rating given by a Customer for a particular Movie.

2. Get Movie with the highest average rating.

3. Get Customer who rated movies the highest on Average , along with the overall average rating.

REST endpoints details :-

 1. To add new rating per customer for a movie :- /api/addNewRating/{customerId}/rate/{movieId}/giveRating/{rating}
    where customerId,movieId and rating are Path Variables. This is a POST  request
    
 2. To get movie with highest average rating :- /api/getMovieWithHighestRating . This is a GET request.
 
 3. To get Customer who rated movies highest on average and average movie rating :-
     /api/getCustomerWithHighestRating . This is a GET request.
     
 
 
 This application takes advantage of the use of Java 8 features such as stream API , Functional Programming using lambda expressions.
 
 REST endpoint examples (Taken from the application live run) :-
 
 
 1. Add Customer movie review.
 http://localhost:8080/api/addNewRating/1/rate/1/giveRating/5
 
 [
    {
        "customerMovieId": {
            "customerId": 1,
            "movieId": 1
        },
        "rating": 5.0
    }
]

http://localhost:8080/api/addNewRating/1/rate/2/giveRating/4.5

[
    {
        "customerMovieId": {
            "customerId": 1,
            "movieId": 1
        },
        "rating": 5.0
    },
    {
        "customerMovieId": {
            "customerId": 1,
            "movieId": 2
        },
        "rating": 4.5
    }
]

http://localhost:8080/api/addNewRating/2/rate/1/giveRating/3

[
    {
        "customerMovieId": {
            "customerId": 1,
            "movieId": 1
        },
        "rating": 5.0
    },
    {
        "customerMovieId": {
            "customerId": 1,
            "movieId": 2
        },
        "rating": 4.5
    },
    {
        "customerMovieId": {
            "customerId": 2,
            "movieId": 1
        },
        "rating": 3.0
    }
]

http://localhost:8080/api/addNewRating/2/rate/2/giveRating/4

[
    {
        "customerMovieId": {
            "customerId": 1,
            "movieId": 1
        },
        "rating": 5.0
    },
    {
        "customerMovieId": {
            "customerId": 1,
            "movieId": 2
        },
        "rating": 4.5
    },
    {
        "customerMovieId": {
            "customerId": 2,
            "movieId": 1
        },
        "rating": 3.0
    },
    {
        "customerMovieId": {
            "customerId": 2,
            "movieId": 2
        },
        "rating": 4.0
    }
]




2. Get movie with highest average rating.

http://localhost:8080/api/getMovieWithHighestRating

{
    "movieId": 2,
    "movieName": "Bat Man",
    "customerMovieRatings": [
        {
            "customerMovieId": {
                "customerId": 1,
                "movieId": 2
            },
            "rating": 4.5
        },
        {
            "customerMovieId": {
                "customerId": 2,
                "movieId": 2
            },
            "rating": 4.0
        }
    ]
}


3. Get Customer with Highest Average movie rating.

http://localhost:8080/api/getCustomerWithHighestRating

{
    "customerId": 2,
    "firstName": "Sushant",
    "lastName": "Jha",
    "customerAverageRating": 4.25,
    "averageRating": 4.125
}
