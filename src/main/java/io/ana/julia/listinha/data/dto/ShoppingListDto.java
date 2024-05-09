package io.ana.julia.listinha.data.dto;

import io.ana.julia.listinha.data.dto.enumDto.PeriodTypeDto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ShoppingListDto {
    private Long id;
    private Long userId;
    private String description;
    private LocalDate date;
    private PeriodTypeDto periodTypeDto;
    private Integer period;
    private BigDecimal amount;

    public ShoppingListDto() {
    }

    public ShoppingListDto(
            Long id,
            Long userId,
            String description,
            LocalDate date,
            PeriodTypeDto periodTypeDto,
            Integer period,
            BigDecimal amount) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.date = date;
        this.periodTypeDto = periodTypeDto;
        this.period = period;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user) {
        this.userId = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public PeriodTypeDto getPeriodTypeDto() {
        return periodTypeDto;
    }

    public void setPeriodTypeDto(PeriodTypeDto periodTypeDto) {
        this.periodTypeDto = periodTypeDto;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
