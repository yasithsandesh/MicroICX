package com.icx.microicx.finance_service.service;

import com.icx.microicx.finance_service.dto.request.SaveRenewalDTO;
import com.icx.microicx.finance_service.dto.response.RenewalDTO;
import com.icx.microicx.finance_service.dto.response.ResponseDTO;
import com.icx.microicx.finance_service.entity.Renewal;
import jakarta.validation.Valid;

import java.util.List;

public interface RenewalService {
    ResponseDTO saveRenewal(@Valid SaveRenewalDTO saveRenewalDTO);

    Renewal getRenewalById(String id);

    List<RenewalDTO> getAllRenewals();

}
