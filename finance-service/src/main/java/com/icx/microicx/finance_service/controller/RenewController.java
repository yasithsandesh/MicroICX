package com.icx.microicx.finance_service.controller;

import com.icx.microicx.finance_service.dto.request.SaveRenewalDTO;
import com.icx.microicx.finance_service.dto.response.RenewalDTO;
import com.icx.microicx.finance_service.dto.response.ResponseDTO;
import com.icx.microicx.finance_service.entity.Renewal;
import com.icx.microicx.finance_service.service.RenewalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/renewal")
@CrossOrigin
public class RenewController {

    @Autowired
    RenewalService renewalService;

    @PostMapping(path = "/save")
    public ResponseEntity<ResponseDTO> saveRenewal(@Valid @RequestBody SaveRenewalDTO saveRenewalDTO){
        return new ResponseEntity<>(renewalService.saveRenewal(saveRenewalDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Renewal> getRenewalById(@PathVariable("id") String id){
        return new ResponseEntity<>(renewalService.getRenewalById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<RenewalDTO>> getAllRenewals(){
        return new ResponseEntity<>(renewalService.getAllRenewals(), HttpStatus.OK);
    }
}
