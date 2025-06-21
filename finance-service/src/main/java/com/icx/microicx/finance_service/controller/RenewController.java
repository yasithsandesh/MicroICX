package com.icx.microicx.finance_service.controller;

import com.icx.microicx.finance_service.service.RenewalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/renewal")
@CrossOrigin
public class RenewController {

    @Autowired
    RenewalService renewalService;
}
