package sg.nus.edu.iss.vttp5_sdf_day12l.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.vttp5_sdf_day12l.model.Country;
import sg.nus.edu.iss.vttp5_sdf_day12l.repo.CountryRepo;

@Service
public class CountryService {
    @Autowired
    CountryRepo countryRepo;

    public List<Country> getCountryList(){
        return countryRepo.getCountries();
    }
}
