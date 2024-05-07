package io.ana.julia.listinha.data.dto;

import io.ana.julia.listinha.data.dto.enumDto.TypeItemDto;
import io.ana.julia.listinha.data.dto.enumDto.UnitOfMeasureItemDto;

import java.math.BigDecimal;

public class ItemDto {

    private Long id;
    private String description;
    private TypeItemDto typeItemDto;
    private UnitOfMeasureItemDto itemMeasurementDto;
    private BigDecimal price;

    public ItemDto() {
    }

    public ItemDto(
            Long id,
            String description,
            TypeItemDto typeItemDto,
            UnitOfMeasureItemDto itemMeasurementDto,
            BigDecimal price) {
        this.id = id;
        this.description = description;
        this.typeItemDto = typeItemDto;
        this.itemMeasurementDto = itemMeasurementDto;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeItemDto getTypeItemDto() {
        return typeItemDto;
    }

    public void setTypeItemDto(TypeItemDto typeItemDto) {
        this.typeItemDto = typeItemDto;
    }

    public UnitOfMeasureItemDto getItemMeasurementDto() {
        return itemMeasurementDto;
    }

    public void setItemMeasurementDto(UnitOfMeasureItemDto price) {
        this.itemMeasurementDto = itemMeasurementDto;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
