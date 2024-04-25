package com.example.phoenixlabtest.controller.item;

import com.example.phoenixlabtest.dto.item.AddItemRequest;
import com.example.phoenixlabtest.model.Item;
import com.example.phoenixlabtest.repository.ItemRepository;
import com.example.phoenixlabtest.service.Item.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/item")
@AllArgsConstructor
public class ItemController {

    private ItemService itemService;
    private ItemRepository itemRepository;
    @GetMapping
    public ResponseEntity<?> getItem() {

        List<Item> result = itemRepository.findAll();

        return ResponseEntity.status(HttpStatus.FOUND).body(result);
    }
    @PostMapping(path = "/add")
    public ResponseEntity<?> addItem(@RequestBody AddItemRequest addItemRequest) {

        Item item = new Item();

        item.setTitle(addItemRequest.title());
        item.setDescription(addItemRequest.description());
        item.setPrice(addItemRequest.price());
        item.setAmount(addItemRequest.amount());

        itemService.addItem(item);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(item);
    }
}
