package TaskFlowManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import TaskFlowManager.Entity.DroppedItem;

public interface DroppedItemRepository extends JpaRepository<DroppedItem, Long> {
   
}
