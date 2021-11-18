package com.sample.Train.controller;

import com.sample.Train.entity.Train;
import com.sample.Train.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping("/addTrain")
    public Train addTrain(@RequestBody Train train) {
        return trainService.saveTrain(train);
    }

    @PostMapping("/addTrains")
    public List<Train> addTrains(@RequestBody List<Train> trains) {
        return trainService.saveTrains(trains);
    }

    @GetMapping("/trains")
    public List<Train> findAllTrains() {
        return trainService.getTrains();
    }

    @GetMapping("/trainById/{id}")
    public Train getTrainById(@PathVariable int id) {
        return trainService.getTrainById(id);
    }

    @GetMapping("/train/{name}")
    public Train getTrainByName(@PathVariable String name) {
        return trainService.getTrainByName(name);
    }

    @PutMapping("/update")
    public Train updateTrain(@RequestBody Train train) {
        return trainService.updateTrain(train);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTrain(@PathVariable int id) {
        return trainService.deleteTrain(id);
    }


}
