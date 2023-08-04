package com.reto.cinco.controller;

import com.reto.cinco.entity.Order;
import com.reto.cinco.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id)
    {
        return orderService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }

    @GetMapping("/zona/{zona}")
    public List<Order> findOrderByZoneV1(@PathVariable("zona") String zona){
        return orderService.findOrderByZoneV1(zona);
    }

    @GetMapping("/zonav2/{zona}")
    public List<Order> findOrderByZoneV2(@PathVariable("zona") String zona){
        return orderService.findOrderByZoneV2(zona);
    }

    @GetMapping("/salesman/{idSalesMan}")
    public List<Order> findAllBySalesMan_Id(@PathVariable("idSalesMan") int idSalesMan){
        return orderService.findAllBySalesMan_Id(idSalesMan);
    }

    @GetMapping("/salesmanv2/{idSalesMan}")
    public List<Order> encontrarOrdenesIdVen(@PathVariable("idSalesMan") int idSalesMan){
        return orderService.encontrarOrdenesIdVen(idSalesMan);
    }

    @GetMapping("/state/{estado}/{id}")
    public List<Order> findAllByStatusAndSalesMan_Id(@PathVariable("estado") String estado, @PathVariable("id")int idSalesMan){
        return orderService.findAllByStatusAndSalesMan_Id(estado,idSalesMan);
    }

    @GetMapping("/statev2/{estado}/{id}")
    public List<Order> encontrarOrdenesXEstadnIdVen(@PathVariable("estado") String estado, @PathVariable("id")int idSalesMan){
        return orderService.encontrarOrdenesXEstadnIdVen(estado,idSalesMan);
    }

    @GetMapping("/date/{strDate}/{idSalesman}")
    public List<Order> ordersSalesManByDate(@PathVariable("strDate") String dateStr, @PathVariable("idSalesman") Integer id) {
        return orderService.ordersSalesManByDate(dateStr,id);
    }
}
