package elizaveta.management.viden.project.http;

import elizaveta.management.viden.project.facade.OrderFacade;
import elizaveta.management.viden.project.http.dto.CreateOrderRequest;
import elizaveta.management.viden.project.http.dto.GetOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderFacade orderFacade;

    @PostMapping
    public void create(@RequestBody CreateOrderRequest createOrderRequest) {
        orderFacade.create(createOrderRequest);
    }

    @GetMapping
    public List<GetOrderResponse> getOrders() {
        return orderFacade.getAll();
    }

    @PutMapping("/{projectId}")
    public void approveProject(@PathVariable("projectId") int projectId) {
        orderFacade.approve(projectId);
    }
}
