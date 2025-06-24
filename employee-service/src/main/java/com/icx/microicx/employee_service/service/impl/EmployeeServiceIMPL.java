package com.icx.microicx.employee_service.service.impl;

import com.icx.microicx.employee_service.dto.request.EmployeeSaveRequestDTO;
import com.icx.microicx.employee_service.dto.response.EmployeeDTO;
import com.icx.microicx.employee_service.dto.response.ResponseDTO;
import com.icx.microicx.employee_service.entity.Employee;
import com.icx.microicx.employee_service.repo.EmployeeRepo;
import com.icx.microicx.employee_service.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public ResponseDTO<EmployeeDTO> updateEmployee(EmployeeSaveRequestDTO employeeSaveRequestDTO, String id) {
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>();

        if(employeeRepo.existsById(Long.parseLong(id))){
            Employee employee = modelMapper.map(employeeRepo.getReferenceById(Long.parseLong(id)), Employee.class);
            employee.setFirstName(employeeSaveRequestDTO.getFirstName());
            employee.setLastName(employeeSaveRequestDTO.getLastName());
            employee.setContactNumber(employeeSaveRequestDTO.getContactNumber());
            employee.setDepartment(employeeSaveRequestDTO.getDepartment());
            employee.setPosition(employeeSaveRequestDTO.getPosition());
            employee.setSalary(employeeSaveRequestDTO.getSalary());
            employeeRepo.save(employee);
            responseDTO.setMessage("update success");
            responseDTO.setStatus(true);
            responseDTO.setData(modelMapper.map(employee, EmployeeDTO.class));
        }else{
            responseDTO.setMessage("Employee not found");
            responseDTO.setStatus(false);
        }

        return responseDTO;
    }

    @Override
    public ResponseDTO<EmployeeDTO> getEmployeeByEmail(String email) {
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>();

        Optional<Employee> employee = employeeRepo.findByEmail(email);

        if(employee.isPresent()){
            EmployeeDTO employeeDTO = modelMapper.map(employee.get(), EmployeeDTO.class);
            responseDTO.setData(employeeDTO);
            responseDTO.setStatus(true);
            responseDTO.setMessage("Employee found successfully");
        }else {
            responseDTO.setMessage("Employee not found with the email: "+email);
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepo.findAll();
        return modelMapper.map(employeeList, new TypeToken<List<EmployeeDTO>>(){}.getType());
    }

    @Override
    public ResponseDTO deactivateEmployee(String id) {
        ResponseDTO responseDTO = new ResponseDTO();

        if(employeeRepo.existsById(Long.parseLong(id))){
            Employee employee = employeeRepo.getReferenceById(Long.parseLong(id));
            employee.setStatus(false);
            employeeRepo.save(employee);
            responseDTO.setStatus(true);
            responseDTO.setMessage("Employee deactivated successfully");
        }else{
            responseDTO.setMessage("Employee not found");
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }
}
