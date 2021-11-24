package com.sample.Train;

import com.sample.Train.entity.Train;
import com.sample.Train.repository.TrainRepository;
import com.sample.Train.service.TrainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static org.junit.jupiter.api.AssertEquals.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainApplicationTests {

	@MockBean
	private TrainRepository trainRepository;

	@Autowired
	private TrainService trainservice;

	@Test
	public void getTrainsTest()
	{
		when(trainRepository.findAll()).thenReturn(Stream.of(
				new Train("IndianExp","Bangalore","8:00"),
				new Train("SouthernExp","Delhi","6:00")).collect(Collectors.toList()));
		assertEquals(2,trainservice.getTrains().size());
	}

	@Test
	public void saveTrainTest()
	{
		Train train=new Train("SR","Chennai","9.00");
		when(trainRepository.save(train)).thenReturn(train);
		assertEquals(train,trainservice.saveTrain(train));
	}

	@Test
	public void deleteTrainTest()
	{
		Train train=new Train("SR","Chennai","9.00");
		trainservice.deleteT(train);
		verify(trainRepository,times(1)).delete(train);
	}

	/*@Test
	public void getTrainByNameTest()
	{
		String name="NorthernExp";
		when(trainRepository.findByName(name)).thenReturn(true);
		assertEquals(1,trainservice.getTrainByName(name));
	}*/

	/*@Test
	void contextLoads() {
	}*/

}
