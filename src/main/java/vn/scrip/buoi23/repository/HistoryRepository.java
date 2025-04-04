package vn.scrip.buoi23.repository;
import vn.scrip.buoi23.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Integer> {
}