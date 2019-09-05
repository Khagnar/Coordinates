package restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restful.entity.GeoLocationEntity;
import java.util.List;


@Repository
public interface GeoLocationRepo extends JpaRepository<GeoLocationEntity, Long> {
    List<GeoLocationEntity> findAllByAddress_Country(String country);
}
