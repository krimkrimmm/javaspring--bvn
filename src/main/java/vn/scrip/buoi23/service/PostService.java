package vn.scrip.buoi23.service;
import vn.scrip.buoi23.entity.Post;
import vn.scrip.buoi23.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    // Lấy danh sách bài viết có status = true (phân trang)
    public Page<Post> getPostsByStatus(boolean status, Pageable pageable) {
        return postRepository.findByStatusTrue(pageable);
    }

    // Lấy N bài viết mới nhất có status = true
    public Page<Post> getLatestPosts(int limit) {
        return postRepository.findByStatusTrue(Pageable.ofSize(limit));
    }
    // Tìm bài viết theo ID
    public Post getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElse(null);
    }

}
