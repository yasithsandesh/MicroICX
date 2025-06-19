package com.icx.microicx.admin_service.service;

import com.icx.microicx.admin_service.dto.AdminDTO;
import com.icx.microicx.admin_service.dto.LoginRequest;
import com.icx.microicx.admin_service.dto.LoginResponse;
import com.icx.microicx.admin_service.entity.Admin;
import com.icx.microicx.admin_service.mapper.AdminMapper;
import com.icx.microicx.admin_service.repository.AdminRepository;
import com.icx.microicx.admin_service.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repo;
    private final AdminMapper mapper;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    @Override
    public AdminDTO createAdmin(AdminDTO dto) {
        Admin admin = mapper.toEntity(dto);
        admin.setPassword(encoder.encode("default123")); // can be replaced with actual
        admin.setActive(true);
        return mapper.toDto(repo.save(admin));
    }

    @Override
    public AdminDTO updateAdmin(Long id, AdminDTO dto) {
        Admin admin = repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        admin.setUsername(dto.getUsername());
        admin.setEmail(dto.getEmail());
        admin.setRole(dto.getRole());
        return mapper.toDto(repo.save(admin));
    }

    @Override
    public AdminDTO getAdminById(Long id) {
        return mapper.toDto(repo.findById(id).orElseThrow());
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public void toggleAdminStatus(String email) {
        Admin admin = repo.findByEmail(email).orElseThrow();
        admin.setActive(!admin.isActive());
        repo.save(admin);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Admin admin = repo.findByUsername(request.getUsername()).orElseThrow();
        if (!encoder.matches(request.getPassword(), admin.getPassword()))
            throw new RuntimeException("Invalid credentials");
        return new LoginResponse(jwtUtil.generateToken(admin));
    }
}
