package io.ana.julia.listinha.data.entity;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import io.ana.julia.listinha.data.dto.enumDto.PeriodTypeDto;
import io.ana.julia.listinha.data.entity.enumEntity.PeriodTypeEntity;
import jakarta.persistence.*;

import java.lang.annotation.ElementType;
import java.math.BigDecimal;
import java.time.Period;
import java.util.Date;

@Entity
public class ListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @Column(name = "id_user",unique = true)
    private Long idUser;
    @Column(name = "description_list",unique = true)
    private String description;
    @Column(name = "date")
    private Date date;
    @Column(name = "period_type")
    @Enumerated(EnumType.STRING)
    private PeriodTypeEntity periodTypeEntity;
    @Column(name = "period")
    private Period period;
    @Column(name = "amount_list")
    private BigDecimal amount;

    public ListEntity(){}
    public ListEntity(
            Long id,
            Long idUser,
            String description,
            Date date,
            PeriodTypeEntity periodTypeEntity,
            Period period,
            BigDecimal amount) {

        this.id = id;
        this.idUser = idUser;
        this.description = description;
        this.date = date;
        this.periodTypeEntity = periodTypeEntity;
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

    public PeriodTypeEntity getPeriodTypeEntity() {
        return periodTypeEntity;
    }

    public void setPeriodTypeEntity(PeriodTypeEntity periodTypeEntity) {
        this.periodTypeEntity = periodTypeEntity;
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
