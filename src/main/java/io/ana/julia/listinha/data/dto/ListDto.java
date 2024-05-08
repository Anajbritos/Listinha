package io.ana.julia.listinha.data.dto;

import io.ana.julia.listinha.data.dto.enumDto.PeriodTypeDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class ListDto {
    private Long id;
    //    private Long idUser;
    private String description;
    private LocalDate date;
    private PeriodTypeDto periodTypeDto;
    private Integer period;
    private BigDecimal amount;

    public ListDto() {
    }

    public ListDto(
            Long id,
//            Long idUser,
            String description,
            LocalDate date,
            PeriodTypeDto periodTypeDto,
            Integer period,
            BigDecimal amount) {
        this.id = id;
//        this.idUser = idUser;
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

//    public Long getIdUser() {
//        return idUser;
//    }

//    public void setIdUser(Long idUser) {
//        this.idUser = idUser;
//    }

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
