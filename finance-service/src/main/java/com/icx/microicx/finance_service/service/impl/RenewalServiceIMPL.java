package com.icx.microicx.finance_service.service.impl;

import com.icx.microicx.finance_service.repo.RenewalRepo;
import com.icx.microicx.finance_service.service.RenewalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RenewalServiceIMPL implements RenewalService {

    @Autowired
    RenewalRepo renewalRepo;
}
