////Viết API backend
////
////GET /api/favorties?page=1&pageSize=10
////
////Lấy danh sách phim yêu thích của user
////Có phân trang

////Fix userId
////POST /api/favorties/add
////{
////“movieId”: 123
////}
////
////Thêm vào danh sách phim yêu thích
////Fix userId
////DELETE /api/favorties/remove

////{
////“movieId”: 123
////}
////
////Xóa khỏi danh sách phim yêu thích
////Fix userId
////DELETE /api/favorties/removeAll
////
////Xóa tất cả phim yêu thích

////Fix userId
package vn.scrip.buoi23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Buoi23Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Buoi23Application.class, args);
	}
}
