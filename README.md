# Giff Store to buy/sell gif's using spring spring webflux and postgreSQL

This Application allows a user to sell/buy a gif. User can upload gif with a price tag and it will be listed in all gifs. other users can browse and buy and if bought can 
download the Gifs for their personal use.
</br>
## Thought process and problem solving
I wanted to create a system where-in a user can buy/sell gifs on an online portal. As it deals with files, the retrieval timeof the files can be affecting the performance
so i used Spring webflux to benefit from it's non-blocking characteristics. My requirement 
was to register a user, and then user can upload/download/buy/sell gifs and here is a prototype a developed.
</br></br>

## Demo
Clicking on the below link will take you to the swagger UI where you can access all the api's and perform operations
```
https://giffs-store.herokuapp.com/swagger-ui.html
```
</br>

### To Create a user, use the below api
```
/user/add
```

Just go to swagger URL followed by -> User -> /user/add </br>
Use the below sample Json format for creating the request.
</br>
```json
{
  "userName": "userName"
}
```
Once the request is sent, the user will be registered in the application.
</br></br>

### To fetch all user details, use the below api
```
/user/all
```

Just go to swagger URL followed by -> User -> /user/all
</br></br>
Once the request is sent, all the user details will be received in response.
</br></br>

### To fetch all Giff details for dashboard/catalog, use the below api
```
/giff/all
```

Just go to swagger URL followed by -> Giff -> /giff/all
</br></br>
Once the request is sent, all the Giff details will be received in response.
</br></br>

### To List a Giff to sell, use the below api
```
/giff/sell-new
```

Just go to swagger URL followed by -> Giff -> /giff/sell-new </br>
Select the File and list your price with your user ID
</br></br>
Once the request is sent, your Giff will be registered to catalog for sale.
</br></br>

### To purchase a gif, use the below api
```
/giff/buy
```

Just go to swagger URL followed by -> Giff -> /giff/buy </br>
Use the below sample Json format for creating the request.
</br>
```json
{
  "giffId": 0,
  "userId": 0
}
```
Once the request is sent, you can downlod the gif in the application.
</br></br>

### To download a Giff, use the below api
```
/giff/{userId}/download/{id}
```

Just go to swagger URL followed by -> Giff -> /giff/{userId}/download/{id} </br>
Fill up the path parameters and that's it.
</br></br>
Once the request is sent, your Giff will be downloaded.
</br></br>

## Key Technologies, Frameworks and tools used:
* [Spring Web-Flux](https://docs.spring.io/spring-framework/docs/5.0.0.BUILD-SNAPSHOT/spring-framework-reference/html/web-reactive.html)
* [PostgreSQL](https://www.postgresql.org/)
* [Swagger](https://swagger.io/about/)
* [HTML, CSS, JS](https://www.w3schools.com/html/html_scripts.asp)
* [Heroku](https://www.heroku.com/)

