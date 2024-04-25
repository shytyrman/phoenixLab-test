package com.example.phoenixlabtest.service.Item;

import com.example.phoenixlabtest.model.Item;
import com.example.phoenixlabtest.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BasicItemService implements ItemService{

    private final ItemRepository itemRepository;
    @Override
    public void addItem(Item item) {
        itemRepository.save(item);
    }
}
