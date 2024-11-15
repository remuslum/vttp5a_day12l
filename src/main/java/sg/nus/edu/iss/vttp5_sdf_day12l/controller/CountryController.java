package sg.nus.edu.iss.vttp5_sdf_day12l.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.nus.edu.iss.vttp5_sdf_day12l.model.Country;
import sg.nus.edu.iss.vttp5_sdf_day12l.service.CountryService;

@Controller
@RequestMapping("/country")
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping("")
    public String countries(Model model){
        List<Country> countryList = countryService.getCountryList();
        model.addAttribute("countrylist", countryList);
        return "countrylist";
    }

    @GetMapping("/filter")
    public String filterCountries(@RequestParam(name = "population") String population, Model model){
        List<Country> countryList = countryService.getCountryList();
        List<Country> filteredCountryList = countryList.stream().filter(x -> x.getPopulation() > Integer.parseInt(population)).collect(Collectors.toList());
        model.addAttribute("countrylist", filteredCountryList);
        return "countrylist";
    }
}
