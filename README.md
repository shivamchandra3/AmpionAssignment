# AmpionAssignment

## Openweather-apis
Simple APIs to use with OpenWeatherMap.org free servicies, requests a APPID on http://openweathermap.org/appid and Start!


## Intro
Simple abstraction layer for using the services are offered by the http://openWeatherMap.org website through its API's. We can easily get the Weather information as per our need on over 400k weather destination (cities). For getting the APPID follow the OpenWeather.org and Complete the request process.


## How It Works:
The main method in class NewTest.java builds the connection with the api server, the main method used is "GET",to retrieve the details of weather forecast.
Response code is validated and printed as well on the console.

It can be run as a Java Application, as both the "Connection-method" and "Parsing the JSON method" are in the same class.
The parse() is called in the main method only, which parses and outputs the data in the required format.


The Key-points of the work done for the Ampion Assignments are as below:

1. The API is successfully hit with the proper connection built. The status code gets validated and printed on the console.

2. The response body has been successfully captured in a string, and the same has been printed out on the console.

3. While the second method which deals about the JSON data parsing, I tried to convert the response body to a json array and then later convert it into json objects.
But since the response which is received from the api is inside one array and we don't have separate objects inside based on dates,timelines or any other unique identification.
