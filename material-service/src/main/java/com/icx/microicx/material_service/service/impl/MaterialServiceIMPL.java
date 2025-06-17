package com.icx.microicx.material_service.service.impl;

import com.icx.microicx.material_service.dto.request.MaterialSaveDTO;
import com.icx.microicx.material_service.dto.response.MaterialDTO;
import com.icx.microicx.material_service.dto.response.ResponseDTO;
import com.icx.microicx.material_service.entitiy.Material;
import com.icx.microicx.material_service.mapper.MaterialMapper;
import com.icx.microicx.material_service.repo.MaterialRepo;
import com.icx.microicx.material_service.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceIMPL implements MaterialService {

    @Autowired
    private MaterialRepo materialRepo;

    @Autowired
    private MaterialMapper materialMapper;

    @Override
    public ResponseDTO addMaterial(MaterialSaveDTO materialSaveDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        if(!materialSaveDTO.getName().isEmpty()){
            Material material =  this.materialMapper.materialSaveDTOToMaterial(materialSaveDTO);
            materialRepo.save(material);
            responseDTO.setMessage("save success");
            responseDTO.setStatus(true);
        }else {
            responseDTO.setMessage("name is empty");
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO<MaterialDTO> updateMaterial(MaterialSaveDTO materialSaveDTO,String id) {
        ResponseDTO<MaterialDTO> responseDTO = new ResponseDTO<>();
        if(!materialSaveDTO.getName().isEmpty()){
          Material material =  this.materialRepo.getReferenceById(Long.parseLong(id));
          material.setName(materialSaveDTO.getName());
          material.setDescription(materialSaveDTO.getDescription());
          material.setUnit(materialSaveDTO.getUnit());
          materialRepo.save(material);
          responseDTO.setMessage("update success");
          responseDTO.setStatus(true);
          responseDTO.setData(this.materialMapper.materialToMaterialDTO(material));
        }else{
            responseDTO.setMessage("name is empty");
        }
        return responseDTO;
    }

    @Override
    public MaterialDTO getMaterialById(String id) {
        Material material = materialRepo.getReferenceById(Long.parseLong(id));
        return this.materialMapper.materialToMaterialDTO(material);
    }

    @Override
    public List<MaterialDTO> getMaterialList() {
       List<Material> materialList = this.materialRepo.findAll();
       return this.materialMapper.materialListToMaterialDTOList(materialList);
    }

    @Override
    public ResponseDTO statusChangeMaterial(String id) {
        ResponseDTO responseDTO = new ResponseDTO();
        Material material = materialRepo.getReferenceById(Long.parseLong(id));
        if(material.isStatus()){
            material.setStatus(false);
            materialRepo.save(material);
        }else{
            material.setStatus(true);
            materialRepo.save(material);
        }
        responseDTO.setMessage("status updated");
        responseDTO.setStatus(true);
        return responseDTO;
    }
}
