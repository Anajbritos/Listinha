package io.ana.julia.listinha.data.dto;

import io.ana.julia.listinha.data.dto.enumDto.PeriodTypeDto;

import java.math.BigDecimal;
import java.time.Period;
import java.util.Date;

public class ListDto {
    private Long id;
    private Long idUser;
    private String description;
    private Date date;
    private PeriodTypeDto periodTypeDto;
    private Period period;
    private BigDecimal amount;

    public ListDto(){}

    public ListDto(
            Long id,
            Long idUser,
            String description,
            Date date,
            PeriodTypeDto periodTypeDto,
            Period period,
            BigDecimal amount) {
        this.id = id;
        this.idUser = idUser;
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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PeriodTypeDto getPeriodTypeDto() {
        return periodTypeDto;
    }

    public void setPeriodTypeDto(PeriodTypeDto periodTypeDto) {
        this.periodTypeDto = periodTypeDto;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
