package com.icx.microicx.finance_service.service.impl;

import com.icx.microicx.finance_service.dto.request.CostSaveRequestDTO;
import com.icx.microicx.finance_service.dto.response.CostDTO;
import com.icx.microicx.finance_service.dto.response.ResponseDTO;
import com.icx.microicx.finance_service.entity.Cost;
import com.icx.microicx.finance_service.repo.CostRepo;
import com.icx.microicx.finance_service.service.CostService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CostServiceIMPL implements CostService {

    @Autowired
    CostRepo costRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseDTO saveCost(CostSaveRequestDTO costSaveRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            Cost cost = modelMapper.map(costSaveRequestDTO, Cost.class);
            costRepo.save(cost);
            responseDTO.setMessage("Successfully saved cost");
            responseDTO.setStatus(true);
        }catch (Exception e){
            responseDTO.setMessage("Error saving cost "+e.getMessage());
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }

    @Override
    public Cost getCostById(String id) {
        Optional<Cost> costOpt = costRepo.findById(Long.parseLong(id));
        return costOpt.orElse(null);
    }

    @Override
    public List<CostDTO> getAllCosts() {
        List<Cost> costList = costRepo.findAll();

        if(costList.size() > 0){
            List<CostDTO> costDTOList = modelMapper.map(costList, new TypeToken<List<CostDTO>>(){}.getType());
            return costDTOList;
        }else {
            return null;
        }
    }

    @Override
    public ResponseDTO deleteCost(String id) {
        ResponseDTO responseDTO = new ResponseDTO();
        if(costRepo.existsById(Long.parseLong(id))){
            costRepo.deleteById(Long.parseLong(id));
            responseDTO.setMessage("Successfully deleted cost");
            responseDTO.setStatus(true);
        }else{
            responseDTO.setMessage("Cost not found");
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }

    @Override
    public List<Cost> getCostByDateRange(LocalDate start, LocalDate end) {
        return costRepo.findByDateBetween(start,end);
    }
}
