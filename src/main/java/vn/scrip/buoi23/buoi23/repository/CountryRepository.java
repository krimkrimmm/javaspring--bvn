package vn.scrip.buoi23.repository;
import vn.scrip.buoi23.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CountryRepository extends JpaRepository<Country, Integer> {
}