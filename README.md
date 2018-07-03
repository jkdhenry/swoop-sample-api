# Swoop Developer Test Sample
A simple Restful Service written in Java that provides basic functionality.

##Demo
A sample version of this api is hosted on [AWS](http://swooplb-38462299.us-west-2.elb.amazonaws.com)

##Configuration
The project consumes an api from [World Weather Online](https://developer.worldweatheronline.com/api/docs/time-zone-api.aspx).
 You will have to register to that api if you wish to run this project locally. 

## Installation

The project supports [Docker](https://www.docker.com).

To build a Docker container, type the following command:

```
./gradlew build docker
```

To run the Docker container locally, type the following command:

```
docker run -e "timeapikey=[YOUR_WORLD_WEATHER_API_KEY]" -p 8080:8080 -t swoop-sample-api
```

##API Endpoints
###Add Numbers
Accepts 2 float values. Adds the 2 values and returns the result.
```
GET /math/add?n1=[float]&n2=[float]
```
```
POST /math/add
Content-Type: application/json
body = {
    firstNumber: [float]
    secondNumber: [float]
}
```

####Response
```json
{
  "result": 6.5
}
```
###Current Time
Returns the current time for YYC.
```
GET /time/now
```
####Response
```json
{
    "epochSeconds": 1530592920,
    "localDateTime": "2018-07-02T22:42:00",
    "isoDateTime": "2018-07-02T22:42:00-06:00",
    "utcOffset": "-06:00"
}
```

###Caching

This project does not utilize any caching. A cache can be useful for an api like the /math/add where the 
provided inputs will always return the same response. The api as it stands is not resource intensive so there 
will not be much of a benefit.

A cache for the /time/now will be beneficial as the service that is used to return the time is rate limited. 
If this api is frequently called, each call will impact this rate limit. A cache can be used to offset this rate 
limit. So only this first request impacts this rate limit. However, since this is a current time api and the 
data returned can easily become stale, special consideration must be taken to invalidate the cache frequently.     

