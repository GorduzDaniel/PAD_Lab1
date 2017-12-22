package md.utm;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class VehicleController {
    private final AtomicLong counter = new AtomicLong();
    private final HashMap<Long, Vehicle> vehicle = new HashMap<>();

    @RequestMapping(path = "/vehicles/{vehicleId}", method = RequestMethod.GET)
    public Vehicle getVehicle(@PathVariable("vehicleId") long vehicleId) {
        return vehicle.get(vehicleId);
    }

    @RequestMapping(path = "/vehicles", method = RequestMethod.GET)
    public HashMap<Long, Vehicle> getVehicles() {
        return vehicle;
    }

    @RequestMapping(path = "/vehicles", method = RequestMethod.POST)
    public void createVehicle(@RequestBody Vehicle vehicle) {
        vehicle.setId(counter.incrementAndGet());
        this.vehicle.put(vehicle.getId(), vehicle);
    }
}
