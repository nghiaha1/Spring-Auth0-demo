package spring.auth0demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.auth0demo.entity.Item;
import spring.auth0demo.repository.ItemRepository;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public Iterable<Item> findAll() {
        Iterable<Item> items = itemRepository.findAll();
        return items;
    }

    public Item update(Item obj) {
        return itemRepository.save(obj);
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }
}
