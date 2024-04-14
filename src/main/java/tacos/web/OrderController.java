package tacos.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import tacos.TacoOrder;
import tacos.data.OrderRepository;

@Slf4j
@RequestMapping("/orders")
@Controller
@SessionAttributes("tacoOrder")
public class OrderController {
	
	private final OrderRepository orderRepository;
	
	public OrderController(OrderRepository orderRepository) {
		this.orderRepository=orderRepository;
	}
	
	@GetMapping("/current")
	public String orderForm() {
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus) {
		if (errors.hasErrors() ) {
			return "orderForm";
		}
		orderRepository.save(tacoOrder);
		sessionStatus.setComplete();
		
		return "redirect:/";
	}
	

}
