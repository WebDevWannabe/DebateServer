package musicplaylist.repository;

import musicplaylist.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, String> {

    @Query(value = "select team_name from teams", nativeQuery = true)
    String[] findTeamNames();

    @Query(value = "select college_name from teams", nativeQuery = true)
    String[] findCollegeNames();

    @Query(value = "select college_logo from teams", nativeQuery = true)
    String[] findCollegeLogo();
}
