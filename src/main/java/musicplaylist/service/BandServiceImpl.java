package musicplaylist.service;

import musicplaylist.model.Band;
import musicplaylist.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BandServiceImpl implements BandService {

    private BandRepository bandRepository;

    @Autowired
    private void setBandRepository(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    @Override
    public String[] findBandNames() {
        return bandRepository.findBandNames();
    }

    @Override
    public String[] findCollegeNames() {
        return bandRepository.findCollegeNames();
    }

    @Override
    public String[] findCollegeLogo() {
        return bandRepository.findCollegeLogo();
    }
}
