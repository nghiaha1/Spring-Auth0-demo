package spring.auth0demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.auth0demo.entity.Item;
import spring.auth0demo.repository.ItemRepository;
import spring.auth0demo.service.ItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/menu/items")
public class ItemApi {

    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Item>> findAll() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<Item> findById(@PathVariable Long id) {
        Optional<Item> optionalItem = itemService.findById(id);
        if (optionalItem.isPresent()) {
            return ResponseEntity.ok(optionalItem.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Item> create(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.update(item));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id,
                                           @RequestBody Item obj) {
        Optional<Item> optionalItem = itemService.findById(id);
        if (optionalItem.isPresent()) {
            return ResponseEntity.ok(itemService.update(obj));
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<Item> deleteById(@PathVariable Long id) {
        Optional<Item> optionalItem = itemService.findById(id);
        if (optionalItem.isPresent()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
