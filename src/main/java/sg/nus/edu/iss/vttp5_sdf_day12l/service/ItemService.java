package sg.nus.edu.iss.vttp5_sdf_day12l.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.vttp5_sdf_day12l.model.Item;
import sg.nus.edu.iss.vttp5_sdf_day12l.repo.ItemRepo;

@Service
public class ItemService {
    
    @Autowired
    ItemRepo itemRepo;

    public List<Item> getItems() {
        return itemRepo.getItems();
    }
}
