package orgexample.sdj3.rest.orderapi.repositoryordao;

import org.springframework.data.jpa.repository.JpaRepository;
import orgexample.sdj3.rest.orderapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
