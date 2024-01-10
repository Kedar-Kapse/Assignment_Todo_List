package TaskFlowManager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import TaskFlowManager.Entity.MenuItem;
import TaskFlowManager.Entity.DroppedItem;
import TaskFlowManager.Repository.MenuItemRepository;
import TaskFlowManager.Repository.DroppedItemRepository;

@Service
public class ItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    private DroppedItemRepository droppedItemRepository;

    public Iterable<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public Iterable<DroppedItem> getAllDroppedItems() {
        return droppedItemRepository.findAll();
    }

    public void dropItem(MenuItem menuItem) {
        // Move the item from menu to dropped items
        DroppedItem droppedItem = new DroppedItem(menuItem.getItemName());
        droppedItemRepository.save(droppedItem);
        menuItemRepository.delete(menuItem);
    }

    // Add more methods as needed

    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    // Add more methods as needed
}
