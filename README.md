# url-shortener-assignment
repo for URL shortener using spring boot and kotlin

POST : http://localhost:8080/api/v1/url/shorten

Req:
    {
      "originalUrl": "https://www.hindustantimes.com/"
    }
    
Res: 
  {
    "id": 1,
    "originalUrl": "https://www.hindustantimes.com/",
    "shortUrl": "nzLfGf",
    "createdTs": "2022-08-21T16:08:48.994182Z"
  }
  
  
    
 GET : http://localhost:8080/api/v1/url/originalurl/{shortUrl}
 
 Res:

 {
    "id": 1,
    "originalUrl": "https://www.hindustantimes.com/",
    "shortUrl": "nzLfGf",
    "createdTs": "2022-08-21T16:08:48.994182Z"
}

Steps to run :
1. git clone https://github.com/Gyan0522/url-shortener-assignment.git
2. mvn install
3. ./mvnw clean spring-boot:run
