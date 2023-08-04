package com.reto.cinco.controller;

import com.reto.cinco.entity.Gadget;
import com.reto.cinco.service.GadgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gadget")
@CrossOrigin(origins = "*")
public class GadgetController {
    @Autowired
    private GadgetService service;

    @GetMapping("/all")
    public List<Gadget> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Gadget getGadget(@PathVariable("id") Integer id){
        return service.getGadget(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget registrar(@RequestBody Gadget gadget){
        return service.registrar(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget actualizar(@RequestBody Gadget gadget){
        return service.actualizar(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }

    @GetMapping("/price/{price}")
    public List<Gadget> findAllByPriceLessThanEqual(@PathVariable("price") double price){
        return service.findAllByPriceLessThanEqual(price);
    }

    @GetMapping("/pricev2/{price}")
    public List<Gadget> gadgetsPrecioMenorIgual(@PathVariable("price") double price){
        return service.gadgetsPrecioMenorIgual(price);
    }

    @GetMapping("/description/{desc}")
    public List<Gadget> findByDescLike(@PathVariable("desc")String desc){
        return service.findByDescLike(desc);
    }

    @GetMapping("/descriptionv2/{desc}")
    public List<Gadget> findByDescriptionContains(@PathVariable("desc")String desc){
        return service.findByDescriptionContains(desc);
    }
}
