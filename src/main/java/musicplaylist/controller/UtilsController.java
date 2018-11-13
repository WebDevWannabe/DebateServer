package musicplaylist.controller;

import musicplaylist.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UtilsController {

    private UtilsService utilsService;

    @Autowired
    private void setUtilsService(UtilsService utilsService) {
        this.utilsService = utilsService;
    }

    @GetMapping(path = "/system_title")
    public @ResponseBody String getSystemTitle() {
        String systemTitle = utilsService.systemTitle();

        return systemTitle;
    }

    @GetMapping(path = "/percentage_criterias")
    private @ResponseBody List<Double> getPercentageCriterias() {
        List<Double> percentageCriterias = new ArrayList<Double>();
        double percentageCriteria1 = utilsService.percentageCriteria1();
        double percentageCriteria2 = utilsService.percentageCriteria2();
        double percentageCriteria3 = utilsService.percentageCriteria3();
        double percentageCriteria4 = utilsService.percentageCriteria4();

        percentageCriterias.add(percentageCriteria1);
        percentageCriterias.add(percentageCriteria2);
        percentageCriterias.add(percentageCriteria3);
        percentageCriterias.add(percentageCriteria4);

        return percentageCriterias;
    }
}
