package com.icx.microicx.employee_service.controller;

import com.icx.microicx.employee_service.dto.request.EmployeeSaveRequestDTO;
import com.icx.microicx.employee_service.dto.response.ResponseDTO;
import com.icx.microicx.employee_service.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/save")
    public ResponseEntity<ResponseDTO> saveEmployee(@Valid @RequestBody EmployeeSaveRequestDTO employeeSaveRequestDTO) {
        return new ResponseEntity<>(employeeService.saveEmployee(employeeSaveRequestDTO), HttpStatus.OK);
    }
}
