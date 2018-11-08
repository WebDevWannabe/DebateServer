package musicplaylist.repository;

import musicplaylist.model.Band;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BandRepository extends CrudRepository<Band, String> {

    @Query(value = "select band_name from bands", nativeQuery = true)
    String[] findBandNames();

    @Query(value = "select college_name from bands", nativeQuery = true)
    String[] findCollegeNames();

    @Query(value = "select college_logo from bands", nativeQuery = true)
    String[] findCollegeLogo();
}
