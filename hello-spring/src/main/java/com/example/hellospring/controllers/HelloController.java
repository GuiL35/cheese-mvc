package com.example.hellospring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;
import java.util.HashMap;

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index() {
        return "Hello world";
    }
    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String createmMssage(HttpServletRequest request){
        String passedName = request.getParameter("person_name");
        String languageGreeting = request.getParameter("greeting");
        return  createMessage(passedName,languageGreeting);
        //another way of doing this
        // String passedName = request.getParameter("person_name");
        //String languageGreeting = request.getParameter("greeting");
        // return languageGreeting + " " + passedName;(languageGreeting == value under)
    }


    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {
        String html = "<form method='post'>" +
                "<input type='text' name='person_name' />" +
                "<select name='greeting'> " +
                "<option value='Bonjour'>French</option>" +
                "<option value='Chinese' selected>Chinese</option>" +
                "<option value='English'>English</option>" +
                "<option value='Itanlian'>Italian</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";
        return html;
    }

    public static String createMessage(String name,String language){
        HashMap<String, String> greetLanguage = new HashMap<>();
        greetLanguage.put("French","Bonjour");
        greetLanguage.put("English","Hello");
        greetLanguage.put("Chinese","你好");

        return greetLanguage.get(language) + ", " + name;
    }
}
