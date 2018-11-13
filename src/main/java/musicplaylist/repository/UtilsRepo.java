package musicplaylist.repository;

import musicplaylist.model.Utils;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UtilsRepo extends CrudRepository<Utils, String> {

    @Query(value = "select system_title from utils", nativeQuery = true)
    String systemTitle();

    @Query(value = "select percentage_criteria_1 from utils", nativeQuery = true)
    Double percentageCriteria1();

    @Query(value = "select percentage_criteria_2 from utils", nativeQuery = true)
    Double percentageCriteria2();

    @Query(value = "select percentage_criteria_3 from utils", nativeQuery = true)
    Double percentageCriteria3();

    @Query(value = "select percentage_criteria_4 from utils", nativeQuery = true)
    Double percentageCriteria4();
}
