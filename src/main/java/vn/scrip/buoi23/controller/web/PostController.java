package vn.scrip.buoi23.controller.web;
import vn.scrip.buoi23.entity.Post;
import vn.scrip.buoi23.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class PostController {
    @Autowired
    private PostService postService;

    // Danh sách bài viết (phân trang)
    @GetMapping("/posts")
    public String listPosts(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<Post> posts = postService.getPostsByStatus(true, PageRequest.of(page, 6));

        model.addAttribute("posts", posts.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", posts.getTotalPages());

        return "posts"; // Trả về trang danh sách bài viết
    }

    // Chi tiết bài viết
    @GetMapping("/posts/{id}")
    public String postDetail(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "post-detail"; // Trả về trang chi tiết bài viết
    }
}



