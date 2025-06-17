package com.icx.microicx.material_service.controller;

import com.icx.microicx.material_service.dto.request.MaterialSaveDTO;
import com.icx.microicx.material_service.dto.response.MaterialDTO;
import com.icx.microicx.material_service.dto.response.ResponseDTO;
import com.icx.microicx.material_service.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping()
    public ResponseEntity<ResponseDTO> saveMaterial(@RequestBody MaterialSaveDTO materialSaveDTO) {
        return new ResponseEntity<>(this.materialService.addMaterial(materialSaveDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ResponseDTO<MaterialDTO>> updateMaterial(@PathVariable String id, @RequestBody MaterialSaveDTO materialSaveDTO) {
        return new ResponseEntity<>(this.materialService.updateMaterial(materialSaveDTO,id), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MaterialDTO> getMaterial(@PathVariable String id) {
        return  new ResponseEntity<>(this.materialService.getMaterialById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<MaterialDTO>> getAllMaterial() {
        return new ResponseEntity<>(this.materialService.getMaterialList(), HttpStatus.OK);
    }

    @GetMapping(path = "/change/{id}")
    public  ResponseEntity<ResponseDTO> changeStatus(@PathVariable String id) {
        return new ResponseEntity<>(this.materialService.statusChangeMaterial(id), HttpStatus.OK);
    }


}
