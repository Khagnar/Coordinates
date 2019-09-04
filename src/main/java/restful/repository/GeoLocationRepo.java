package restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restful.entity.GeoLocationEntity;


@Repository
public interface GeoLocationRepo extends JpaRepository<GeoLocationEntity, Long> {
}
