package com.icx.microicx.material_service.service;

import com.icx.microicx.material_service.dto.request.MaterialSaveDTO;
import com.icx.microicx.material_service.dto.response.MaterialDTO;
import com.icx.microicx.material_service.dto.response.ResponseDTO;

import java.util.List;

public interface MaterialService {
    ResponseDTO addMaterial(MaterialSaveDTO materialSaveDTO);
    ResponseDTO<MaterialDTO> updateMaterial(MaterialSaveDTO materialSaveDTO,String id);
    MaterialDTO getMaterialById(String id);
    List<MaterialDTO> getMaterialList();
    ResponseDTO statusChangeMaterial(String id);
}
