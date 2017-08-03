package org.lauchcode.cheesemvc.controllers;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Request;

import java.util.ArrayList;
import java.util.HashMap;
//import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;

@Controller
@RequestMapping("cheese")
public class CheesaController {

    static ArrayList<String> cheeses = new ArrayList<>();

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {
        //pass the data to template/view


        //HashMap<String,String> cheeses =  new HashMap<>();

        /*
        cheeses.add("cheddar");
        cheeses.add("parmesan");
        cheeses.add("munster");
        */


        model.addAttribute("cheeses",cheeses);
        model.addAttribute("title","My cheese"); //key,value
        return "cheese/index"; //template name going to render
        //add line 10+ add a directory put the template into that+add cheese in line16
    }

    //display the form
    @RequestMapping(value = "add", method = RequestMethod.GET)
    //specify get or post(it has same route)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title","Add cheese");
        return "cheese/add";
    }

    //right version but not pro...
    //public String processAddCheeseForm(HttpServletRequest request) {
    // String chesseName = request.getParameter("cheeseName");

    //process the form
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName ) { //@RequestParam this would be an error if do not put String later
            cheeses.add(cheeseName);

            //redirect to /cheese (already have line19 so leave empty after redirect)
            return "redirect:";
    }

}
