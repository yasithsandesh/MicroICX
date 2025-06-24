package com.icx.microicx.employee_service.controller;

import com.icx.microicx.employee_service.dto.request.EmployeeSaveRequestDTO;
import com.icx.microicx.employee_service.dto.response.EmployeeDTO;
import com.icx.microicx.employee_service.dto.response.ResponseDTO;
import com.icx.microicx.employee_service.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/save")
    public ResponseEntity<ResponseDTO> saveEmployee(@Valid @RequestBody EmployeeSaveRequestDTO employeeSaveRequestDTO) {
        return new ResponseEntity<>(employeeService.saveEmployee(employeeSaveRequestDTO), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ResponseDTO<EmployeeDTO>> updateEmployee(@PathVariable String id, @RequestBody EmployeeSaveRequestDTO employeeSaveRequestDTO) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeSaveRequestDTO, id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<EmployeeDTO>> getEmployeeByEmail(@RequestParam String email) {
        return new ResponseEntity<>(employeeService.getEmployeeByEmail(email), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PutMapping(path = "/deactivate")
    public ResponseEntity<ResponseDTO> deactivateEmployee(@RequestParam String id) {
        return new ResponseEntity<>(employeeService.deactivateEmployee(id), HttpStatus.OK);
    }
}
