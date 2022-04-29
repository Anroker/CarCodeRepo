package pl.arcsoftware.carcoderepo.service;

import org.springframework.stereotype.Service;
import pl.arcsoftware.carcoderepo.repository.CarRepository;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    
}
