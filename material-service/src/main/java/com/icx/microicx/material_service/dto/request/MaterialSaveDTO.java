package com.icx.microicx.material_service.dto.request;

import com.icx.microicx.material_service.enums.Unit;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;

public class MaterialSaveDTO implements Serializable {
    private String name;
    private String description;
    private Unit unit;

    public MaterialSaveDTO() {

    }
    public MaterialSaveDTO(String name, String description, Unit unit) {
        this.name = name;
        this.description = description;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
