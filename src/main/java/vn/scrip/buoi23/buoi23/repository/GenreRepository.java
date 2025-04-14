package vn.scrip.buoi23.repository;
import vn.scrip.buoi23.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}