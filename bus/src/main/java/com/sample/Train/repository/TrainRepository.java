package com.sample.Train.repository;

import com.sample.Train.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Integer> {
    Train findByName(String name);
}
