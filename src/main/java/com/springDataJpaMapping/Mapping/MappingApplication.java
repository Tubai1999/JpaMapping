package com.springDataJpaMapping.Mapping;

//import com.springDataJpaMapping.Mapping.service.forProfileSetting.Vehicle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MappingApplication implements CommandLineRunner {

//	private final Vehicle vehicle;
	@Value("${my.variable}")
	private String myVariable;

//	public MappingApplication(Vehicle vehicle) {
//		this.vehicle = vehicle;
//	}

	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		System.out.println("may variable "+myVariable);
//		vehicle.numberOfWheeles();
	}
}
