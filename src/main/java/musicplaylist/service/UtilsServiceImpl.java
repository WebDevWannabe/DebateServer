package musicplaylist.service;

import musicplaylist.repository.UtilsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilsServiceImpl implements UtilsService {

    private UtilsRepo utilsRepo;

    @Autowired
    private void setUtilsRepo(UtilsRepo utilsRepo) {
        this.utilsRepo = utilsRepo;
    }

    @Override
    public String systemTitle() {
        return utilsRepo.systemTitle();
    }

    @Override
    public double percentageCriteria1() {
        return utilsRepo.percentageCriteria1();
    }

    @Override
    public double percentageCriteria2() {
        return utilsRepo.percentageCriteria2();
    }

    @Override
    public double percentageCriteria3() {
        return utilsRepo.percentageCriteria3();
    }

    @Override
    public double percentageCriteria4() {
        return utilsRepo.percentageCriteria4();
    }
}
