package com.icx.microicx.employee_service.service.impl;

import com.icx.microicx.employee_service.dto.request.EmployeeSaveRequestDTO;
import com.icx.microicx.employee_service.dto.response.ResponseDTO;
import com.icx.microicx.employee_service.entity.Employee;
import com.icx.microicx.employee_service.repo.EmployeeRepo;
import com.icx.microicx.employee_service.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseDTO saveEmployee(EmployeeSaveRequestDTO employeeSaveRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Employee employee = modelMapper.map(employeeSaveRequestDTO, Employee.class);
            employeeRepo.save(employee);
            responseDTO.setStatus(true);
            responseDTO.setMessage("Employee saved successfully");
        }catch (Exception e){
            responseDTO.setMessage("Error saving employee: "+e.getMessage());
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }
}
