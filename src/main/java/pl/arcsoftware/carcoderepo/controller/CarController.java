package pl.arcsoftware.carcoderepo.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.arcsoftware.carcoderepo.models.Car;
import pl.arcsoftware.carcoderepo.models.User;
import pl.arcsoftware.carcoderepo.payload.request.car.CarRequest;
import pl.arcsoftware.carcoderepo.payload.request.car.CarUpdateRequest;
import pl.arcsoftware.carcoderepo.payload.response.MessageResponse;
import pl.arcsoftware.carcoderepo.payload.response.car.CarResponse;
import pl.arcsoftware.carcoderepo.repository.CarRepository;
import pl.arcsoftware.carcoderepo.repository.UserRepository;
import pl.arcsoftware.carcoderepo.security.services.UserDetailsImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))

@RestController
@RequestMapping("/api/car")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Car controller", description = "Endpoints for use to manage your car")
public class CarController {

    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public CarController(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @Operation(
            deprecated = true
    )
    @GetMapping("/test")
    public ResponseEntity<?> test(Authentication principal) {

        UserDetailsImpl userDetails = (UserDetailsImpl) principal.getPrincipal();

        return ResponseEntity.ok("userName: " + userDetails.getUsername() + " UserID: " + userDetails.getId());
    }

    @Operation(
            summary = "Add car to logged user ( require to be authenticated )"
    )
    @PostMapping("/addCar")
    public ResponseEntity<?> addCarToUser(Authentication authentication, @RequestBody CarRequest carRequest) {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Optional<User> user = userRepository.findById(userDetails.getId());

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

    @Operation(
            summary = "Get car by id",
            description = "endpoint returns your car",
    parameters = @Parameter(in = ParameterIn.PATH, name = "id", description = "id of car"))
    @GetMapping("/getCar/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
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

    @GetMapping("/getAllCars")
    public ResponseEntity<?> getAllCars(Authentication authentication) {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Optional<User> user = userRepository.findById(userDetails.getId());

        List<Car> carList = carRepository.findCarByUserOrderById(user.get());
        List<CarResponse> carResponseList = carList.stream().map(this::buildCarResponse).collect(Collectors.toList());

        return ResponseEntity.ok(carResponseList);
    }

    @PutMapping("/updateCar/{id}")
    public ResponseEntity<?> updateCar(Authentication authentication, @PathVariable(value = "id") Long carId,
                                       @Valid @RequestBody CarUpdateRequest carUpdateRequest) {

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

    private CarResponse buildCarResponse(Car car) {
        CarResponse carResponse = new CarResponse();

        carResponse
                .setId(car.getId())
                .setModel(car.getModel())
                .setEngine(car.getEngine())
                .setVin(car.getVin())
                .setYearOfProduction(car.getYear_of_production());

        return carResponse;
    }
}
