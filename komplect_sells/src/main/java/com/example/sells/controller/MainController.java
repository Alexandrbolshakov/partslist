package com.example.sells.controller;

import com.example.sells.domain.Part;
import com.example.sells.domain.Supplier;
import com.example.sells.repos.PartRepo;
import com.example.sells.repos.SupplierRepo;
import com.example.sells.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    PartRepo partRepo;

    @Autowired
    SupplierRepo supplierRepo;

    @Autowired
    PartService partService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "hello";
    }

    @GetMapping("/start")
    public String start(@RequestParam(required = false, defaultValue = "") String filter,
                        Model model,
                        @PageableDefault(sort = {"id"},direction = Sort.Direction.DESC)Pageable pageable){
        Page<Part> page;

        if(filter!=null&&!filter.isEmpty()) {
            page = partRepo.findByPartNumber(filter, pageable);
        }else{
            page = partRepo.findAll(pageable);
        }
        model.addAttribute("page", page);
        model.addAttribute("url", "/start");
        model.addAttribute("filter", filter);

        return "start";
    }

    @GetMapping("/addPart")
    public String addPartPage(Map<String, Object>model){
        return "addPart";
    }

    @PostMapping("/addPart")
    public String addPart(Map<String,Object> model,
                          @RequestParam String partNumber,
                          @RequestParam String name,
                          @RequestParam String quantityStr,
                          @RequestParam String priceStr,
                          @RequestParam(required = false, defaultValue = "") String supplier,
                          @PageableDefault(sort = {"id"},direction = Sort.Direction.DESC)Pageable pageable
                          ){
        Supplier supplierFromDB = supplierRepo.findByName(supplier);
        if(supplierFromDB==null){
            model.put("message", "Поставщик не существует");
            return "addPart";
        }
        Integer quantity = Integer.parseInt(quantityStr);
        Double price = Double.parseDouble(priceStr);
        Part part = new Part(partNumber,name,quantity,price,supplierFromDB, LocalDateTime.now().toLocalDate());
        partRepo.save(part);
        Iterable<Part> parts = partRepo.findAll();
        Page<Part> page = partRepo.findAll(pageable);

        model.put("parts", parts);
        model.put("url", "/start");
        model.put("page", page);

        return "start";
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") long id,
                           Map<String, Object>model){
        Part part = partRepo.findById(id).get();
        model.put("part", part);
        return "editPage";
    }

    @PostMapping(value = "/edit")
    public String editPart(
                            @RequestParam Long id,
                            @RequestParam String partNumber,
                            @RequestParam String name,
                            @RequestParam String quantityStr,
                            @RequestParam String priceStr,
                            @RequestParam(required = false, defaultValue = "") String supplier,
                           Map<String, Object>model){
        Supplier supplierFromDB = supplierRepo.findByName(supplier);
        Part part = partRepo.findById(id).get();
        part.setPartNumber(partNumber);
        part.setName(name);
        Integer quantity = Integer.parseInt(quantityStr);
        part.setQuantity(quantity);
        Double price = Double.parseDouble(priceStr);
        part.setPrice(price);
        part.setSupplier(supplierFromDB);
        part.setDateTime(LocalDateTime.now().toLocalDate());
        partRepo.save(part);
        return "redirect:/start";
    }


    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") long id,
                         Map<String, Object>model){
        partRepo.deleteById(id);
        return "redirect:/start";
    }

}
