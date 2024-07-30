package Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/home")
public class IndexController {

    @RequestMapping(value = "/id")
    String getIdByValue(@RequestParam("id") String personId){
        System.out.println("ID is "+personId);
        return "Get ID from query string of URL with value element";
    }

    @RequestMapping(value = "/personId")
    String getId(@RequestParam String personId){
        System.out.println("ID is "+personId);
        return "Get ID from query string of URL without value element";
    }
    @RequestMapping(value = "/name")
    String getName(@RequestParam(value = "person", required = false)      String personName){
        return "Required element of request param";
    }

    @RequestMapping(value = "/head", headers = {"content- type=text/plain"})
    String post(){
        return "Mapping applied along with headers";
    }

    @RequestMapping(value = "/fetch/{id}", method = RequestMethod.GET)
    String getDynamicUriValue(@PathVariable String id){
        System.out.println("ID is "+id);
        return "Dynamic URI parameter fetched";
    }
    @RequestMapping(value = "/fetch/{id:[a-z]+}/{name}", method = RequestMethod.GET)
    String getDynamicUriValueRegex(@PathVariable("name") String name){
        System.out.println("Name is "+name);
        return "Dynamic URI parameter fetched using regex";
    }

    @GetMapping("/person")
    public @ResponseBody ResponseEntity<String> getPerson() {
        return new ResponseEntity<String>("Response from GET", HttpStatus.OK);
    }

    @GetMapping("/person/{id}")
    public @ResponseBody ResponseEntity<String> getPersonById(@PathVariable String id){
        return new ResponseEntity<String>("Response from GET with id " +id,HttpStatus.OK);
    }

    @PostMapping("/person")
    public @ResponseBody ResponseEntity<String> postPerson() {
        return new ResponseEntity<String>("Response from POST method", HttpStatus.OK);
    }

    @PutMapping("/person")
    public @ResponseBody ResponseEntity<String> putPerson() {
        return new ResponseEntity<String>("Response from PUT method", HttpStatus.OK);
    }

    @DeleteMapping("/person")
    public @ResponseBody ResponseEntity<String> deletePerson() {
        return new ResponseEntity<String>("Response from DELETE method", HttpStatus.OK);
    }

    @PatchMapping("/person")
    public @ResponseBody ResponseEntity<String> patchPerson() {
        return new ResponseEntity<String>("Response from PATCH method", HttpStatus.OK);
    }


    @RequestMapping("/example1")
    public ModelAndView example1() {
        ModelAndView modelAndView = new ModelAndView("exampleView");
        modelAndView.addObject("message", "Hello, World!");
        return modelAndView;
    }
    @RequestMapping("/example2")
    public InternalResourceView example2() {
        return new InternalResourceView("/WEB-INF/views/example.jsp");
    }
    @RequestMapping("/example3")
    public String example3(Model model) {
        model.addAttribute("message", "Hello, World!");
        return "exampleView";
    }
    @RequestMapping("/example4")
    public ResponseEntity<String> example4() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Custom-Header", "value");
        return new ResponseEntity<>("Hello, World!", headers, HttpStatus.OK);
    }

    @RequestMapping("/redirect")
    public RedirectView redirect(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {
        System.out.println(name);
        redirectAttributes.addAttribute("name", name);
        return new RedirectView("page2");
    }
    @RequestMapping("/page2")
    public String page2(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name.toUpperCase());
        return "page2";
    }

    @GetMapping("/forwardWithForwardPrefix")
    public ModelAndView redirectWithUsingForwardPrefix(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefix");
        return new ModelAndView("forward:/redirectedUrl", model);
    }
    @GetMapping("/forwardWithForwardPrefix")
    public ModelAndView redirectWithUsingForwardPrefix2(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefix");
        return new ModelAndView("forward:/redirectedUrl", model);
    }
    @GetMapping("/redirectedUrl")
    public ModelAndView redirection(
            ModelMap model,
            @ModelAttribute("flashAttribute") Object flashAttribute) {

        model.addAttribute("redirectionAttribute", flashAttribute);
        return new ModelAndView("redirection", model);
    }
}
