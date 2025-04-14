package vn.scrip.buoi23.repository;

import vn.scrip.buoi23.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    List<Favorite> findByUserId(Integer userId);
    Page<Favorite> findByUserId(Integer userId, Pageable pageable); // 🆕 Thêm dòng này

    Optional<Favorite> findByUserIdAndMovieId(Integer userId, Integer movieId);
    void deleteByUserIdAndMovieId(Integer userId, Integer movieId);
    void deleteByUserId(Integer userId);
}
