package com.icx.microicx.finance_service.service.impl;

import com.icx.microicx.finance_service.dto.request.SaveRenewalDTO;
import com.icx.microicx.finance_service.dto.response.RenewalDTO;
import com.icx.microicx.finance_service.dto.response.ResponseDTO;
import com.icx.microicx.finance_service.entity.Renewal;
import com.icx.microicx.finance_service.repo.RenewalRepo;
import com.icx.microicx.finance_service.service.RenewalService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenewalServiceIMPL implements RenewalService {

    @Autowired
    RenewalRepo renewalRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseDTO saveRenewal(SaveRenewalDTO saveRenewalDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            Renewal renewal = modelMapper.map(saveRenewalDTO, Renewal.class);
            renewalRepo.save(renewal);
            responseDTO.setMessage("Successfully saved Renewal");
            responseDTO.setStatus(true);
        }catch (Exception e){
            responseDTO.setMessage("Error saving Renewal "+e.getMessage());
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }

    @Override
    public Renewal getRenewalById(String id) {
        Optional<Renewal> renewal = renewalRepo.findById(Long.parseLong(id));
        return renewal.orElse(null);
    }

    @Override
    public List<RenewalDTO> getAllRenewals() {
        List<Renewal> renewals = renewalRepo.findAll();

        if(renewals.size() > 0){
            List<RenewalDTO> renewalDTOS = modelMapper.map(renewals, new TypeToken<List<RenewalDTO>>(){}.getType());
            return renewalDTOS;
        }else {
            return null;
        }
    }
}
