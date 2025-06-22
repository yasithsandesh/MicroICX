package com.icx.microicx.finance_service.controller;

import com.icx.microicx.finance_service.dto.request.CostSaveRequestDTO;
import com.icx.microicx.finance_service.dto.response.CostDTO;
import com.icx.microicx.finance_service.dto.response.ResponseDTO;
import com.icx.microicx.finance_service.entity.Cost;
import com.icx.microicx.finance_service.service.CostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/cost")
@CrossOrigin
public class CostController {

    @Autowired
    CostService costService;

    @PostMapping(path = "/save")
    public ResponseEntity<ResponseDTO> saveCost(@Valid @RequestBody CostSaveRequestDTO costSaveRequestDTO) {
        return new ResponseEntity<>(costService.saveCost(costSaveRequestDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cost> getCostById(@PathVariable("id") String id) {
        return new ResponseEntity<>(costService.getCostById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<CostDTO>> getAllCosts() {
        return new ResponseEntity<>(costService.getAllCosts(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteCost(@PathVariable(value = "id") String id){
        return new ResponseEntity<>(costService.deleteCost(id), HttpStatus.OK);
    }

    @GetMapping(path = "/filter")
    public ResponseEntity<List<Cost>> getCostByDateRange(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate end
    ){
        return new ResponseEntity<>(costService.getCostByDateRange(start, end), HttpStatus.OK);
    }
}
