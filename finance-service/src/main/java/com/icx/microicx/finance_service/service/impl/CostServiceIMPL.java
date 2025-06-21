package com.icx.microicx.finance_service.service.impl;

import com.icx.microicx.finance_service.repo.CostRepo;
import com.icx.microicx.finance_service.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostServiceIMPL implements CostService {

    @Autowired
    CostRepo costRepo;
}
