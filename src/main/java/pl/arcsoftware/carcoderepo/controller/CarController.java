package pl.arcsoftware.carcoderepo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.arcsoftware.carcoderepo.models.Car;
import pl.arcsoftware.carcoderepo.models.FuelNotes;
import pl.arcsoftware.carcoderepo.models.User;
import pl.arcsoftware.carcoderepo.dto.request.car.CarRequest;
import pl.arcsoftware.carcoderepo.dto.request.car.CarUpdateRequest;
import pl.arcsoftware.carcoderepo.dto.request.car.fuel.FuelCreateRequest;
import pl.arcsoftware.carcoderepo.dto.response.MessageResponse;
import pl.arcsoftware.carcoderepo.dto.response.car.CarResponse;
import pl.arcsoftware.carcoderepo.dto.response.car.fuel.FuelResponse;
import pl.arcsoftware.carcoderepo.repository.CarRepository;
import pl.arcsoftware.carcoderepo.repository.FuelNotesRepository;
import pl.arcsoftware.carcoderepo.repository.UserRepository;
import pl.arcsoftware.carcoderepo.security.services.UserDetailsImpl;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/car")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Car controller", description = "Endpoints for use to manage your car")
public class CarController {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final FuelNotesRepository fuelNotesRepository;

    public CarController(CarRepository carRepository, UserRepository userRepository, FuelNotesRepository fuelNotesRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.fuelNotesRepository = fuelNotesRepository;
    }

    /**************
     *CAR METHODS*
     **************/

    @Operation(
            summary = "Add car to logged user ( require to be authenticated )"
    )
    @PostMapping("/addCar")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> addCarToUser(Authentication authentication, @RequestBody CarRequest carRequest) {

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


    @Operation(
            summary = "Get car by id",
            description = "Returns your selected car",
            parameters = @Parameter(in = ParameterIn.PATH, name = "id", description = "id of the car"))
    @GetMapping("/{id}")
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

    @Operation(
            summary = "Get all of your cars",
            description = "Returns your cars"
    )
    @GetMapping("/")
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

    @Operation(
            summary = "Update car",
            description = "Updates your car with provided data"
    )
    @PutMapping("/{id}/updateCar")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> updateCar(@PathVariable(value = "id") Long carId, @Valid @RequestBody CarUpdateRequest carUpdateRequest) {

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

    /**************
     *CAR MAINTENANCE METHODS*
     **************/

    @Operation(
            summary = "Add fuel to car"
    )
    @PostMapping("/{id}/addFuel")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> addFuelToCar(@PathVariable Long id, @RequestBody FuelCreateRequest fuelCreateRequest) {

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
                fuelNotes.getDistance()
        ));
    }

    @Operation(
            deprecated = true
    )
    @GetMapping("/fuel/get")
    public ResponseEntity<?> getFuelAfterAndBefore(@RequestParam("After") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime afterDate, @RequestParam("Before") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime beforeDate) {

        List<FuelNotes> fuelNotes = fuelNotesRepository.findFuelNotesByCreatedDateAfterAndCreatedDateBefore(afterDate, beforeDate);

        return ResponseEntity.ok(fuelNotes);
    }

    @Operation(
            summary = "Get all the refueling of the car",
            description = "Returns list of refueling for the car",
            parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "id", description = "id of the car"),
                    @Parameter(in = ParameterIn.QUERY, name = "After", description = "Date to start search - format: yyyy-MM-ddTHH:MM:SS"),
                    @Parameter(in = ParameterIn.QUERY, name = "Before", description = "Date to end search - format: yyyy-MM-ddTHH:MM:SS")
            }
    )
    @GetMapping("/{id}/fuel/getWithDates")
    public ResponseEntity<?> getFuelAfterAndBeforeWithCar(@RequestParam("After") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime afterDate, @RequestParam("Before") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime beforeDate, @PathVariable Long id) {

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

    @GetMapping("{id}/fuel/avg")
    public ResponseEntity<?> getFuelAvg(@PathVariable Long id) {

        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Cant find car by id!"));
        }

        return ResponseEntity.ok(fuelNotesRepository.avgFuel(optionalCar.get()));
    }

    @GetMapping("{id}/distance/avg")
    public ResponseEntity<?> getDistanceAvg(@PathVariable Long id) {

        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Cant find car by id!"));
        }

        return ResponseEntity.ok(fuelNotesRepository.avgDistance(optionalCar.get()));
    }



    /*********
     *HELPERS*
     *********/

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

    private FuelResponse buildFuelResponse(FuelNotes fuel) {
        FuelResponse fuelResponse = new FuelResponse();

        fuelResponse
                .setFuel(fuel.getFuel())
                .setDistance(fuel.getDistance());

        return fuelResponse;
    }
}
