package com.icx.microicx.admin_service.service;

import com.icx.microicx.admin_service.dto.AdminDTO;
import com.icx.microicx.admin_service.dto.LoginRequest;
import com.icx.microicx.admin_service.dto.LoginResponse;

import java.util.List;

public interface AdminService {
    AdminDTO createAdmin(AdminDTO dto);
    AdminDTO updateAdmin(Long id, AdminDTO dto);
    AdminDTO getAdminById(Long id);
    List<AdminDTO> getAllAdmins();
    void toggleAdminStatus(String email);
    LoginResponse login(LoginRequest request);
}