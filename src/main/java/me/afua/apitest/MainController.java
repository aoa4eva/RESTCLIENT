package me.afua.apitest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Controller
public class MainController {

    @RequestMapping("/")
    private @ResponseBody String index(Model model) throws IOException {
        RestTemplate theRest = new RestTemplate();

        RestTemplateBuilder builder = new RestTemplateBuilder();
        EmbeddedPeople people;
       // people = builder.basicAuthorization("username","3ef0e222-3167-40d5-bd1e-166e967909b5").build().getForObject("http://localhost:8081/persons",EmbeddedPeople.class);
        people = builder.build().getForObject("http://localhost:8081/persons",EmbeddedPeople.class);
        for(Person eachPerson: people.get_embedded().getPersons())
        {
            System.out.println(eachPerson.getFirstName());
        }
        model.addAttribute("people",people);
      return "Check your console";
    }

    @RequestMapping("/postvalue")
    private @ResponseBody String showPost(Model model) throws
            IOException{

        //Create the object
        Person thisPerson = new Person();
        thisPerson.setFirstName("Some One");
        thisPerson.setLastName("LastName");

        //Create an HTTPEntity from the object
        HttpEntity personToSend = new HttpEntity(thisPerson);

        //Create the Rest Template
        RestTemplate builder = new RestTemplate();
        builder.postForLocation("http://localhost:8081/persons",thisPerson);

        return "Data posted";
    }
}
