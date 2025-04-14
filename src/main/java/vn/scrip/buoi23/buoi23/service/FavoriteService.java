package vn.scrip.buoi23.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.scrip.buoi23.entity.Favorite;
import vn.scrip.buoi23.repository.FavoriteRepository;

import java.util.List;
@Service
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final Integer fixedUserId = 1;
    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public Page<Favorite> getFavorites(int page, int pageSize) {
        List<Favorite> favorites = favoriteRepository.findByUserId(fixedUserId);
        int start = Math.min((page - 1) * pageSize, favorites.size());
        int end = Math.min(start + pageSize, favorites.size());
        return new PageImpl<>(favorites.subList(start, end), PageRequest.of(page - 1, pageSize), favorites.size());
    }
    public void addFavorite(Integer movieId) {
        boolean exists = favoriteRepository.findByUserIdAndMovieId(fixedUserId, movieId).isPresent();
        if (!exists)
        {
            Favorite favorite = new Favorite();
            favorite.setUserId(fixedUserId);
            favorite.setMovieId(movieId);
            favoriteRepository.save(favorite);
        }
    }
    public void removeFavorite(Integer movieId) {
        favoriteRepository.deleteByUserIdAndMovieId(fixedUserId, movieId);
    }

    public void removeAllFavorites() {
        favoriteRepository.deleteByUserId(fixedUserId);
    }
}