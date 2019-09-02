package restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restful.entity.GeoLocation;

@Repository
public interface GeoLocationRepo extends JpaRepository<GeoLocation, Long> {
}
