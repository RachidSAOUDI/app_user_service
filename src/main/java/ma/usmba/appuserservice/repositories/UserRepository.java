package ma.usmba.appuserservice.repositories;

import ma.usmba.appuserservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
