package com.icx.microicx.finance_service.controller;

import com.icx.microicx.finance_service.dto.request.CostSaveRequestDTO;
import com.icx.microicx.finance_service.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cost")
@CrossOrigin
public class CostController {

    @Autowired
    CostService costService;

    @PostMapping(params = "/save")
    public String saveCost(@RequestBody CostSaveRequestDTO costSaveRequestDTO) {
        return "saved";
    }

}
