package pl.arcsoftware.carcoderepo.service;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pl.arcsoftware.carcoderepo.dto.request.car.CarRequest;
import pl.arcsoftware.carcoderepo.dto.request.car.CarUpdateRequest;
import pl.arcsoftware.carcoderepo.dto.request.car.fuel.FuelCreateRequest;
import pl.arcsoftware.carcoderepo.dto.response.MessageResponse;
import pl.arcsoftware.carcoderepo.dto.response.car.CarResponse;
import pl.arcsoftware.carcoderepo.dto.response.car.fuel.FuelResponse;
import pl.arcsoftware.carcoderepo.models.Car;
import pl.arcsoftware.carcoderepo.models.FuelNotes;
import pl.arcsoftware.carcoderepo.models.User;
import pl.arcsoftware.carcoderepo.repository.CarRepository;
import pl.arcsoftware.carcoderepo.security.services.UserDetailsImpl;
import pl.arcsoftware.carcoderepo.repository.UserRepository;
import pl.arcsoftware.carcoderepo.repository.FuelNotesRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final FuelNotesRepository fuelNotesRepository;

    public ResponseEntity<?> responseEntity(Authentication authentication, CarRequest carRequest) {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Optional<User> user = userRepository.findById(userDetails.getId());

        if (user.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Cant find user!"));
        }

        Car car = new Car();

        car.setEngine(carRequest.getEngine());
        car.setModel(carRequest.getModel());

        car.setUser(user.get());

        carRepository.save(car);

        return ResponseEntity.ok(new CarResponse(
                        "success",
                        carRequest.getModel(),
                        carRequest.getEngine()
                )
        );

    }

    public ResponseEntity<?> getCarById(Long id) {
        Optional<Car> car = carRepository.findById(id);

        if (car.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Cant find car by id!"));
        }

        return ResponseEntity.ok(new CarResponse()
                .setId(car.get().getId())
                .setModel(car.get().getModel())
                .setEngine(car.get().getEngine())
                .setVin(car.get().getVin())
                .setYearOfProduction(car.get().getYear_of_production())
                .setOkResponse("success"));
    }

    public ResponseEntity<?> getAllCars(Authentication authentication) {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Optional<User> user = userRepository.findById(userDetails.getId());

        if (user.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Cant find user!"));
        }

        List<Car> carList = carRepository.findCarByUserOrderById(user.get());
        List<CarResponse> carResponseList = carList.stream().map(this::buildCarResponse).collect(Collectors.toList());

        return ResponseEntity.ok(carResponseList);

    }

    public ResponseEntity<?> updateCar(Long carId, CarUpdateRequest carUpdateRequest) {

        Optional<Car> optionalCar = carRepository.findById(carId);

        if (optionalCar.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Cant find car by id!"));
        }

        Car car = optionalCar.get();

        car.setModel(carUpdateRequest.getModel());
        car.setEngine(carUpdateRequest.getEngine());
        car.setYear_of_production(carUpdateRequest.getYear_of_production());
        car.setVin(carUpdateRequest.getVin());

        carRepository.save(car);

        return ResponseEntity.ok(new CarResponse()
                .setId(car.getId())
                .setModel(car.getModel())
                .setEngine(car.getEngine())
                .setYearOfProduction(car.getYear_of_production())
                .setVin(car.getVin())
                .setOkResponse("success"));

    }

    public ResponseEntity<?> addFuelToCar(Long id, FuelCreateRequest fuelCreateRequest) {

        Optional<Car> car = carRepository.findById(id);

        if (car.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Cant find car by id!"));
        }
        FuelNotes fuelNotes = new FuelNotes();

        fuelNotes
                .setFuel(fuelCreateRequest.getFuel())
                .setDistance(fuelCreateRequest.getDistance())
                .setCar(car.get());

        fuelNotesRepository.save(fuelNotes);

        return ResponseEntity.ok(new FuelResponse(
                "success",
                fuelNotes.getFuel(),
                fuelNotes.getDistance()));
    }

    public ResponseEntity<?> getFuelAfterAndBeforeWithCar(LocalDateTime afterDate, LocalDateTime beforeDate, Long id) {

        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Cant find car by id!"));
        }

        List<FuelNotes> fuelNotes = fuelNotesRepository.findFuelNotesByCreatedDateAfterAndCreatedDateBeforeAndCar(afterDate, beforeDate, optionalCar.get());
        List<FuelResponse> fuelResponseList = fuelNotes.stream().map(this::buildFuelResponse).toList();

        return ResponseEntity.ok(fuelResponseList);
    }

    public ResponseEntity<?> getFuelAvg(Long id){

        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Cant find car by id!"));
        }

        return ResponseEntity.ok(fuelNotesRepository.avgFuel(optionalCar.get()));

    }

    public ResponseEntity<?> getDistanceAvg(Long id) {

        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Cant find car by id!"));
        }

        return ResponseEntity.ok(fuelNotesRepository.avgDistance(optionalCar.get()));

    }

    public
        CarService(UserRepository userRepository, CarRepository carRepository, FuelNotesRepository fuelNotesRepository)
        {
            this.userRepository = userRepository;
            this.carRepository = carRepository;
            this.fuelNotesRepository = fuelNotesRepository;

        }

        private CarResponse buildCarResponse (Car car){
            CarResponse carResponse = new CarResponse();

            carResponse
                    .setId(car.getId())
                    .setModel(car.getModel())
                    .setEngine(car.getEngine())
                    .setVin(car.getVin())
                    .setYearOfProduction(car.getYear_of_production());

            return carResponse;
        }
        private FuelResponse buildFuelResponse (FuelNotes fuel){
            FuelResponse fuelResponse = new FuelResponse();

            fuelResponse
                    .setFuel(fuel.getFuel())
                    .setDistance(fuel.getDistance());

            return fuelResponse;
        }

}
