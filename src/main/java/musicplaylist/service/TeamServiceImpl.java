package musicplaylist.service;

import musicplaylist.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    @Autowired
    private void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public String[] findTeamNames() {
        return teamRepository.findTeamNames();
    }

    @Override
    public String[] findCollegeNames() {
        return teamRepository.findCollegeNames();
    }

    @Override
    public String[] findCollegeLogo() {
        return teamRepository.findCollegeLogo();
    }
}
