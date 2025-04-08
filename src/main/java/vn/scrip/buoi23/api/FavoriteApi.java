package vn.scrip.buoi23.api;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import vn.scrip.buoi23.entity.Favorite;
import vn.scrip.buoi23.service.FavoriteService;

@RestController
@RequestMapping("/api/favorties")
public class FavoriteApi {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping
    public Page<Favorite> getFavorites(@RequestParam(defaultValue = "1") int page,
                                       @RequestParam(defaultValue = "10") int pageSize) {
        return favoriteService.getFavorites(page, pageSize);
    }

    @PostMapping("/add")
    public void addFavorite(@RequestBody FavoriteRequest request) {
        favoriteService.addFavorite(request.getMovieId());
    }

    @DeleteMapping("/remove")
    public void removeFavorite(@RequestBody FavoriteRequest request) {
        favoriteService.removeFavorite(request.getMovieId());
    }

    @DeleteMapping("/removeAll")
    public void removeAllFavorites() {
        favoriteService.removeAllFavorites();
    }

    @Data
    public static class FavoriteRequest {
        private Long movieId;
    }
}