package kart.poc.ekart_poc_crud;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/courier")
public class CourierController {
    private List<Courier> couriers = new ArrayList<>();

    @PostConstruct
    public void init() {
        couriers.add(new Courier(1, "Navishika", "Laptop", "123 Street", 1234567890L, 1500.00, "transit", "Priya"));
        couriers.add(new Courier(2, "Karthika", "Phone", "456 Avenue", 9876543210L, 800.00, "delivered", "Hari"));
        couriers.add(new Courier(3, "Harshini", "Watch", "6/239 Namakkal", 6747655654L, 2000.00, "transit", "Madhu"));
        couriers.add(new Courier(4, "Harini", "Speaker", "543 Gate", 1896443247578L, 3500.00, "delivered", "Manju"));
        couriers.add(new Courier(5, "Hema", "Lens", "Kallakurichi", 865855545435L, 4000.00, "transit", "Abi"));
      }
    @PostMapping("/")
    public Courier addCourier(@RequestBody Courier courier) {
        couriers.add(courier);
        return courier;
    }
    @PutMapping("/")
    public String updateItemStatus(@RequestBody Courier courier) {
        for (Courier existingCourier : couriers) {
            if (existingCourier.getParcelId() == courier.getParcelId()) {
                existingCourier.setItemStatus(courier.getItemStatus());
                return "Courier status updated for " + courier.getParcelId();
            }
        }
        return "Courier not found for " + courier.getParcelId();
    }
    @GetMapping("/executive/{executiveName}")
    public List<Courier> getByExecutive(@PathVariable String executiveName) {
        List<Courier> result = new ArrayList<>();
        for (Courier courier : couriers) {
            if (courier.getExecutiveName().equalsIgnoreCase(executiveName)) {
                result.add(courier);
            }
        }
        return result;
    }
    
    @GetMapping("/address/{receiverAddress}")
    public List<Courier> getByAddress(@PathVariable String receiverAddress) {
        List<Courier> result = new ArrayList<>();
        for (Courier courier : couriers) {
            if (courier.getReceiverAddress().equalsIgnoreCase(receiverAddress)) {
                result.add(courier);
            }
        }
        return result;
    } 
    @GetMapping("/receiver/{receiverName}")
    public List<Courier> getByReceiver(@PathVariable String receiverName) {
        List<Courier> result = new ArrayList<>();
        for (Courier courier : couriers) {
            if (courier.getReceiverName().equalsIgnoreCase(receiverName)) {
                result.add(courier);
            }
        }
        return result;
    }

    @GetMapping("/")
    public List<Courier> getAllCouriers() {
        return couriers;
    }
}


