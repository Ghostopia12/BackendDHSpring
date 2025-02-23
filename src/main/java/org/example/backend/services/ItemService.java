package org.example.backend.services;

import org.example.backend.models.Item;
import org.example.backend.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item itemDetails) {
        return itemRepository.findById(id).map(item -> {
            item.setTitle(itemDetails.getTitle());
            item.setDescription(itemDetails.getDescription());
            item.setStatus(itemDetails.getStatus());
            return itemRepository.save(item);
        }).orElseThrow(() -> new RuntimeException("Item no encontrado"));
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
