package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String name, @RequestParam String helloTranslated) {
        return helloTranslated + name + "!";
    }

    // Handles requests at /hello/languages
    @GetMapping("languages")
    @ResponseBody
    public String createMessage() {
        return "<html>" +
                    "<body>" +
                        "<form action='hello' method='post'>" + // tells the form to submit a request to /hello (which already works with helloWithQueryParam
                            "<input type='text' name='name'>" +
                            "<label for='language-select'>Choose a language!</label>" +
                                "<select name='createMessage' id='language-select'" +
                                "<option value=''>--Please choose a language--</option>" +
                                "<option value='Hello, '>English</option>" +
                                "<option value='Bonjour, '>French</option>" +
                                "<option value='Hola, '>Spanish</option>" +
                                "<option value='Hallo, '>German</option>" +
                                "<option value='Dia dhuit, '>Irish</option>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";


        // for notes: cleaner solution posted by LaunchCode:
//        @RequestMapping(value="hello", method = RequestMethod.POST)
//        @ResponseBody
//        public String helloPost(@RequestParam String name, @RequestParam String language) {
//            if (name == null) {
//                name = "World";
//            }
//
//            return createMessage(name, language);
//
//            // For a bonus mission, students can change this response text to look nicer.
//            // This is subjective, but students should be modifying the HTML of the response string.
//        }
//
//        public static String createMessage(String n, String l) {
//            String greeting = "";
//
//            if (l.equals("english")) {
//                greeting = "Hello";
//            }
//            else if (l.equals("french")) {
//                greeting = "Bonjour";
//            }
//            else if (l.equals("italian")) {
//                greeting = "Bonjourno";
//            }
//            else if (l.equals("spanish")) {
//                greeting = "Hola";
//            }
//            else if (l.equals("german")) {
//                greeting = "Hallo";
//            }
//
//            return greeting + " " + n;
//        }
    }
}
