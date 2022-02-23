package com.example.demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("")
@RestController
public class ApiControler {
    private RestTemplate restTemplate;
    @Autowired
    public ApiControler(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }


@GetMapping("/api")


    public ResponseEntity<?> getDataFromApi(){
    String  url  ="https://api.spoonacular.com/recipes/findByIngredients?apiKey=8a7d17fa9581449e9600bd8457c07f9a&ingredients=apples,+flour,+sugar&number=10";
    var data =restTemplate.exchange(url, HttpMethod.GET, null,  String.class) ;
    return  ResponseEntity.ok(data.getBody());
}



}
