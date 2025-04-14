package vn.scrip.buoi23.api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import vn.scrip.buoi23.dto.FavoriteRequest;
import vn.scrip.buoi23.entity.Favorite;

import vn.scrip.buoi23.service.FavoriteService;
@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteApi {
    private final FavoriteService favoriteService;
    // Lấy danh sách phim yêu thích (có phân trang)
    @GetMapping
    public Page<Favorite> getFavorites
    (
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        return favoriteService.getFavorites(page, pageSize);
    }
    // Thêm một phim vào danh sách yêu thích
    @PostMapping("/add")
    public void addFavorite(@RequestBody FavoriteRequest request) {
        favoriteService.addFavorite(request.getMovieId());
    }

    // Xóa một phim khỏi danh sách yêu thích
    @DeleteMapping("/remove")
    public void removeFavorite(@RequestBody FavoriteRequest request) {
        favoriteService.removeFavorite(request.getMovieId());
    }
    // Xóa toàn bộ danh sách yêu thích của user
    @DeleteMapping("/removeAll")
    public void removeAllFavorites() {
        favoriteService.removeAllFavorites();
    }
}

