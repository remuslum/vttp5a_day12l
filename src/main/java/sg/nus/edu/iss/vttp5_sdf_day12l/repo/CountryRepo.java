package sg.nus.edu.iss.vttp5_sdf_day12l.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import sg.nus.edu.iss.vttp5_sdf_day12l.model.Country;

@Repository
public class CountryRepo {
    public List<Country> getCountries(){
        Country city1 = new Country("SG", "Singapore", 6000000);
        Country city2 = new Country("MY", "Malaysia", 8000000);
        Country city3 = new Country("HK", "Hong Kong", 9000000);
        Country city4 = new Country("EU", "Europe", 7000000);
        Country city5 = new Country("CN", "China", 3000000);

        List<Country> countryList = List.of(city1, city2, city3, city4, city5);
        return countryList;
    }
}
