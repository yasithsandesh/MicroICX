package com.icx.microicx.admin_service.mapper;

import com.icx.microicx.admin_service.dto.AdminDTO;
import com.icx.microicx.admin_service.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminDTO toDto(Admin entity);
    Admin toEntity(AdminDTO dto);
}