package com.sample.Train.service;

import com.sample.Train.entity.Train;
import com.sample.Train.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public Train saveTrain(Train train) {
        return trainRepository.save(train);
    }

    public List<Train> saveTrains(List<Train> products) {
        return trainRepository.saveAll(products);
    }

    public List<Train> getTrains() {
        return trainRepository.findAll();
    }

    public Train getTrainById(int id) {
        return trainRepository.findById(id).orElse(null);
    }

    public Train getTrainByName(String name) {
        return trainRepository.findByName(name);
    }

    public String deleteTrain(int id) {
        trainRepository.deleteById(id);
        return "Train removed !! " + id;
    }

    public Train updateTrain(Train train) {
        Train existingTrain = trainRepository.findById(train.getId()).orElse(null);
        existingTrain.setName(train.getName());
        existingTrain.setDestination(train.getDestination());
        existingTrain.setDeparture(train.getDeparture());
        return trainRepository.save(existingTrain);
    }


}

