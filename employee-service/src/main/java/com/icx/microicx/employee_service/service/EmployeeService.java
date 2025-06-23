package com.icx.microicx.employee_service.service;

import com.icx.microicx.employee_service.dto.request.EmployeeSaveRequestDTO;
import com.icx.microicx.employee_service.dto.response.ResponseDTO;
import jakarta.validation.Valid;

public interface EmployeeService {
    ResponseDTO saveEmployee(@Valid EmployeeSaveRequestDTO employeeSaveRequestDTO);
}
