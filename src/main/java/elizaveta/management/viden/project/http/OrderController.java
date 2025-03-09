package elizaveta.management.viden.project.http;

import elizaveta.management.viden.project.facade.OrderFacade;
import elizaveta.management.viden.project.facade.ProjectFacade;
import elizaveta.management.viden.project.http.dto.CreateOrderRequest;
import elizaveta.management.viden.project.http.dto.CreateProjectRequest;
import elizaveta.management.viden.project.http.dto.CreateProjectResponse;
import elizaveta.management.viden.project.http.dto.EditProjectRequest;
import elizaveta.management.viden.project.http.dto.EditProjectResponse;
import elizaveta.management.viden.project.http.dto.GetProjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
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
}
