package sg.nus.edu.iss.vttp5_sdf_day12l.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.nus.edu.iss.vttp5_sdf_day12l.model.Country;
import sg.nus.edu.iss.vttp5_sdf_day12l.service.CountryService;

@Controller
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    CountryService countryService;

    @GetMapping("")
    public String weather(@RequestParam(required = true, name = "country", defaultValue = "Singapore") String city,
    @RequestParam(name = "metrics", defaultValue = "centimetres") String metrics, Model model){
        model.addAttribute("city", city);
        model.addAttribute("metrics",metrics);
        return "weather";
    }

    @GetMapping("/city/{country}/metrics/{metrics}")
    public String weatherPath(@PathVariable(required = true, name = "country") String city, 
    @PathVariable(name = "metrics", required=true) String metrics, Model model){
        model.addAttribute("city", city);
        model.addAttribute("metrics",metrics);
        return "weather";
    }

    @GetMapping("/pagea")
    public String pageA(Model model){
        String[] units = {"centimetre", "metre", "kilometre"};
        List<Country> countries = countryService.getCountryList();

        model.addAttribute("countries", countries);
        model.addAttribute("units", units);
        return "pagea";
    }

    @GetMapping("/forma")
    public String showForm(){
        return "forma";
    }

    @PostMapping("/forma")
    public String handlePageA(@RequestBody MultiValueMap<String,String> form){
        Map<String, String> formData = new HashMap<>();

        for(String str: form.keySet()){
            formData.put(str, form.getFirst(str));
        }
        return "forma";
    }
}
