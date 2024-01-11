package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Car;
import com.example.form.CarForm;
import com.example.service.CarService;

@Controller
public class CarController {

	private final CarService carService;

	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}
	@GetMapping("/index")
	public String index(Model model
			, @ModelAttribute CarForm carForm
			, @RequestParam(value = "carId", required = false) Integer id
			, @RequestParam(value = "carName", required = false) String name
			, @RequestParam(value = "carPassengers", required = false) Integer passengers) {
		List<Car> cars = this.carService.findAll(id, name, passengers);
		model.addAttribute("cars", cars);
		return "index";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute CarForm carForm) {
		this.carService.insert(carForm.getName(), carForm.getPassengers());
		return "redirect:/index";
	}

	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable("id") Integer id, @ModelAttribute CarForm carForm, Model model) {
		Car car = this.carService.findById(id);
		carForm.setName(car.getName());
		carForm.setPassengers(car.getPassengers());
		model.addAttribute("id", id);
		return "edit";
	}

	@PostMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, @ModelAttribute CarForm carForm) {
		this.carService.update(id, carForm.getName(), carForm.getPassengers());
		return "redirect:/index";
	}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		this.carService.deleteById(id);
		return "redirect:/index";
	}

	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") Integer id, Model model) {
		Car car = this.carService.findById(id);
		model.addAttribute("car", car);
		return "detail";
	}
}
