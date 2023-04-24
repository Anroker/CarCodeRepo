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

import pl.arcsoftware.carcoderepo.models.FuelNotes;

import pl.arcsoftware.carcoderepo.dto.request.car.CarRequest;
import pl.arcsoftware.carcoderepo.dto.request.car.CarUpdateRequest;
import pl.arcsoftware.carcoderepo.dto.request.car.fuel.FuelCreateRequest;
import pl.arcsoftware.carcoderepo.repository.CarRepository;
import pl.arcsoftware.carcoderepo.repository.FuelNotesRepository;
import pl.arcsoftware.carcoderepo.repository.UserRepository;
import pl.arcsoftware.carcoderepo.service.CarService;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/car")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Car controller", description = "Endpoints for use to manage your car")
public class CarController {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final FuelNotesRepository fuelNotesRepository;
    private final CarService carService;

    public CarController(CarRepository carRepository, UserRepository userRepository, FuelNotesRepository fuelNotesRepository, CarService carService) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.fuelNotesRepository = fuelNotesRepository;
        this.carService = carService;
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

        return carService.responseEntity(authentication, carRequest);

    }

    @Operation(
            summary = "Get car by id",
            description = "Returns your selected car",
            parameters = @Parameter(in = ParameterIn.PATH, name = "id", description = "id of the car"))
    @GetMapping("/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {

        return carService.getCarById(id);

    }

    @Operation(
            summary = "Get all of your cars",
            description = "Returns your cars"
    )
    @GetMapping("/")
    public ResponseEntity<?> getAllCars(Authentication authentication) {

        return carService.getAllCars(authentication);
    }

    @Operation(
            summary = "Update car",
            description = "Updates your car with provided data"
    )
    @PutMapping("/{id}/updateCar")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> updateCar(@PathVariable(value = "id") Long carId, @Valid @RequestBody CarUpdateRequest carUpdateRequest) {

        return carService.updateCar(carId, carUpdateRequest);

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

        return carService.addFuelToCar(id, fuelCreateRequest);

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

        return carService.getFuelAfterAndBeforeWithCar(afterDate, beforeDate, id);
    }

    @GetMapping("{id}/fuel/avg")
    public ResponseEntity<?> getFuelAvg(@PathVariable Long id) {

        return carService.getFuelAvg(id);
    }

    @GetMapping("{id}/distance/avg")
    public ResponseEntity<?> getDistanceAvg(@PathVariable Long id) {

        return carService.getDistanceAvg(id);
    }
    }









