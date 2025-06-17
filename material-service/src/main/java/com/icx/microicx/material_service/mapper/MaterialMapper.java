package com.icx.microicx.material_service.mapper;

import com.icx.microicx.material_service.dto.request.MaterialSaveDTO;
import com.icx.microicx.material_service.dto.response.MaterialDTO;
import com.icx.microicx.material_service.entitiy.Material;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
    MaterialMapper INSTANCE = Mappers.getMapper(MaterialMapper.class);
    Material materialSaveDTOToMaterial(MaterialSaveDTO materialSaveDTO);
    MaterialDTO materialToMaterialDTO(Material material);
    List<MaterialDTO> materialListToMaterialDTOList(List<Material> materialList);
}
