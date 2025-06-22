package com.icx.microicx.finance_service.service;

import com.icx.microicx.finance_service.dto.request.CostSaveRequestDTO;
import com.icx.microicx.finance_service.dto.response.CostDTO;
import com.icx.microicx.finance_service.dto.response.ResponseDTO;
import com.icx.microicx.finance_service.entity.Cost;

import java.time.LocalDate;
import java.util.List;

public interface CostService {
    ResponseDTO saveCost(CostSaveRequestDTO costSaveRequestDTO);

    Cost getCostById(String id);

    List<CostDTO> getAllCosts();

    ResponseDTO deleteCost(String id);

    List<Cost> getCostByDateRange(LocalDate start, LocalDate end);
}
