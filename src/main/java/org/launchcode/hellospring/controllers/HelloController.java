package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    // Static - Handles request at /hello
    @GetMapping("helloSpring")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    // Static - Handles request at /goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Dynamic - Handles requests of the form /hello?name=(name that will print)
    // Updated to RequestMapping - which allows GET and POST request.
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /helloPath/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello'>" + // tells the form to submit a request to /hello (which already works with helloWithQueryParam
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
        // note that by default, this form is submitted with a GET request!
        // so, the GetMapping annotations in QueryParam work with this.
    }

    @GetMapping("postForm")
    @ResponseBody
    public String helloPostForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // tells the form to submit a request to /hello (which already works with helloWithQueryParam
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
        // updated method to post request!
    }
}
