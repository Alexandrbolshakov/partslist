package com.example.sells.controller;

import com.example.sells.domain.Part;
import com.example.sells.domain.Supplier;
import com.example.sells.repos.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class SupplierController {

    @Autowired
    SupplierRepo supplierRepo;

    @GetMapping("/supplier")
    public String supplier(Map<String, Object> model){
        Iterable<Supplier> suppliers = supplierRepo.findAll();
        model.put("suppliers", suppliers);
        return "supplier";
    }

    @PostMapping("/supplier")
    public String addSupplier(Map<String, Object> model,
                             @RequestParam String name,
                             @RequestParam String phoneNumber,
                             @RequestParam String email,
                             @RequestParam String contactName,
                             @RequestParam String indexStr){

        Supplier supplierFromDb = supplierRepo.findByName(name);
        if(supplierFromDb!=null){
            model.put("message", "Такой поставщик уже существует");
            return "supplier";
        }
        Double index = Double.parseDouble(indexStr);
        Supplier supplier = new Supplier(name, phoneNumber,email,contactName, index);
        supplierRepo.save(supplier);
        Iterable<Supplier> suppliers = supplierRepo.findAll();
        model.put("suppliers", suppliers);
        model.put("message", "Поставщик добавлен в базу данных");

        return "supplier";
    }

    @GetMapping(value = "/editSupplier/{id}")
    public String editPage(@PathVariable("id") long id,
                           Map<String, Object>model){
        Supplier supplier = supplierRepo.findById(id).get();
        model.put("supplier", supplier);
        return "editSupplier";
    }

    @PostMapping(value = "/editSupplier")
    public String editSupplier(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String phoneNumber,
            @RequestParam String email,
            @RequestParam String contactName,
            @RequestParam String indexStr,
            Map<String, Object>model){
        Supplier supplier = supplierRepo.findById(id).get();
        supplier.setName(name);
        supplier.setPhoneNumber(phoneNumber);
        supplier.setEmail(email);
        supplier.setContactName(contactName);
        Double index = Double.parseDouble(indexStr);
        supplier.setIndex(index);
        supplierRepo.save(supplier);
        return "redirect:/supplier";
    }

    @GetMapping(value = "/deleteSupplier/{id}")
    public String deleteSupplier(@PathVariable("id") long id,
                         Map<String, Object>model){
        supplierRepo.deleteById(id);
        return "redirect:/supplier";
    }

}
