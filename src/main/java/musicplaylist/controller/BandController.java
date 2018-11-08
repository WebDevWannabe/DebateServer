package musicplaylist.controller;

import musicplaylist.model.Band;
import musicplaylist.model.Score;
import musicplaylist.service.BandService;
import musicplaylist.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BandController {

    private BandService bandService;

    @Autowired
    private void setBandService(BandService bandService) {
        this.bandService = bandService;
    }

//    @RequestMapping(path = "/hello")
//    public @ResponseBody String sendResponse() {
//        System.out.println("Testing from the controller");
//
//        Boolean test = true;
//        String ID = "Test";
//
//        if(scoreService.findAllQuestions(ID)) {
//            System.out.println(ID + " found");
//        } else {
//            System.out.println(ID + " not found");
//        }
//
//        return "This is the response from the server";
//    }

    @RequestMapping(path = "/band_names")
    public @ResponseBody String[] getBandNames() {
        String[] bandNames = bandService.findBandNames();
        int lenBandNames = bandNames.length;

        do {
            System.out.println(lenBandNames + " band names current length");
            System.out.println(bandNames);
            lenBandNames -= 1;
        } while (lenBandNames != 0);

        return bandNames;
    }

    @RequestMapping(path = "/college_names")
    public @ResponseBody String[] getCollegeNames() {
        String[] collegeNames = bandService.findCollegeNames();
        int lenCollegeNames = collegeNames.length;

        do {
            System.out.println(lenCollegeNames + " college names current length");
            System.out.println(collegeNames);
            lenCollegeNames -= 1;
        } while (lenCollegeNames != 0);

        return collegeNames;
    }

    @RequestMapping(path = "/college_logos")
    public @ResponseBody String[] getCollegeLogo() {
        String[] collegeLogo = bandService.findCollegeLogo();
        int lenCollegeLogo = collegeLogo.length;

        do {
            System.out.println(lenCollegeLogo + " college logo current length");
            System.out.println(collegeLogo);
            lenCollegeLogo -= 1;
        } while (lenCollegeLogo != 0);

        return collegeLogo;
    }
}
