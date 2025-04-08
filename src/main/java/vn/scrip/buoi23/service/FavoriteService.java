package vn.scrip.buoi23.service;
import vn.scrip.buoi23.entity.Favorite;
import vn.scrip.buoi23.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private static final Long FIXED_USER_ID = 1L;
    public Page<Favorite> getFavorites(int page, int size) {
        return favoriteRepository.findByUserId(FIXED_USER_ID, PageRequest.of(page - 1, size));
    }

    public void addFavorite(Long movieId) {
        boolean exists = favoriteRepository.findByUserIdAndMovieId(FIXED_USER_ID, movieId).isPresent();
        if (!exists) {
            Favorite favorite = new Favorite();
            favorite.setUserId(FIXED_USER_ID);
            favorite.setMovieId(movieId);
            favoriteRepository.save(favorite);
        }
    }

    public void removeFavorite(Long movieId) {
        favoriteRepository.deleteByUserIdAndMovieId(FIXED_USER_ID, movieId);
    }
    public void removeAllFavorites() {
        favoriteRepository.deleteAllByUserId(FIXED_USER_ID);
    }
}





