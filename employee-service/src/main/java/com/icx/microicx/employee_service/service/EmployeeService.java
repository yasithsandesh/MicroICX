package com.icx.microicx.employee_service.service;

import com.icx.microicx.employee_service.dto.request.EmployeeSaveRequestDTO;
import com.icx.microicx.employee_service.dto.response.EmployeeDTO;
import com.icx.microicx.employee_service.dto.response.ResponseDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface EmployeeService {
    ResponseDTO saveEmployee(@Valid EmployeeSaveRequestDTO employeeSaveRequestDTO);

    ResponseDTO<EmployeeDTO> updateEmployee(EmployeeSaveRequestDTO employeeSaveRequestDTO, String id);

    ResponseDTO<EmployeeDTO> getEmployeeByEmail(String email);

    List<EmployeeDTO> getAllEmployees();

    ResponseDTO deactivateEmployee(String id);
}
