package sg.nus.edu.iss.vttp5_sdf_day12l.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import sg.nus.edu.iss.vttp5_sdf_day12l.model.Item;

@Repository
public class ItemRepo {

    public List<Item> getItems(){
        Item item1 = new Item("Apple M4 mini", 5);
        Item item2 = new Item("iPhone 16 Max Pro", 15);
        Item item3= new Item("Prada Wallet", 25);
        Item item4 = new Item("Hermes Tote Bag", 10);
        Item item5 = new Item("LV suitcase", 8);

        List<Item> itemList = List.of(item1, item2, item3, item4, item5);
        return itemList;

    }
}
