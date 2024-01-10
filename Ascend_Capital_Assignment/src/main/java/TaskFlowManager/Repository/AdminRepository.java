package TaskFlowManager.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import TaskFlowManager.Entity.SignIn_Login;
public interface AdminRepository extends JpaRepository<SignIn_Login, Long> {
	
	public SignIn_Login findByEmail(String email);

}
