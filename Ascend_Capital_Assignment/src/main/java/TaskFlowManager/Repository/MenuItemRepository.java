package TaskFlowManager.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import TaskFlowManager.Entity.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
   
}
