package vn.scrip.buoi23.repository;

import vn.scrip.buoi23.entity.User;
import vn.scrip.buoi23.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRole(UserRole userRole);
}