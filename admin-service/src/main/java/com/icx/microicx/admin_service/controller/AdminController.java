package com.icx.microicx.admin_service.controller;

import com.icx.microicx.admin_service.dto.AdminDTO;
import com.icx.microicx.admin_service.dto.LoginRequest;
import com.icx.microicx.admin_service.dto.LoginResponse;
import com.icx.microicx.admin_service.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/admins")
@Tag(name = "Admin APIs")
public class AdminController {

    private final AdminService service;

    @Operation(summary = "Create a new admin")
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AdminDTO> create(@RequestBody @Valid AdminDTO dto) {
        return ResponseEntity.ok(service.createAdmin(dto));
    }

    @Operation(summary = "Update admin by ID")
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AdminDTO> update(@PathVariable Long id, @RequestBody @Valid AdminDTO dto) {
        return ResponseEntity.ok(service.updateAdmin(id, dto));
    }

    @Operation(summary = "Get all admins")
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<AdminDTO>> all() {
        return ResponseEntity.ok(service.getAllAdmins());
    }

    @Operation(summary = "Get admin by ID")
    @GetMapping("/{id}")
    public ResponseEntity<AdminDTO> byId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAdminById(id));
    }

    @Operation(summary = "Toggle admin active status by email")
    @PutMapping("/email/{email}/toggle")
    public ResponseEntity<Void> toggle(@PathVariable String email) {
        service.toggleAdminStatus(email);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Login to receive JWT token")
    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest req) {
        return ResponseEntity.ok(service.login(req));
    }
}