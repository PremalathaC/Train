package com.sample.Train;

import com.sample.Train.entity.Train;
import com.sample.Train.repository.TrainRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class StateTest {

    @Autowired
    private TrainRepository trainRepository;

    @Test
    public void testCreateState()
    {
        Train train=new Train("IndianExp","Bangalore","8:00");
        Train savedtrain=trainRepository.save(train);
        assertNotNull(savedtrain);
    }

    @Test
    public void testTrainByNameExist(){
        String name = "SouthernRailway";
        Train train=trainRepository.findByName(name);
        assertThat(Train.getByName()).isEqualTo(name);
    }

}
