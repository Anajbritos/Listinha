package io.ana.julia.listinha.data.entity;

import io.ana.julia.listinha.data.entity.enumEntity.PeriodTypeEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_shopping_list")
public class ShoppingListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    @Column(name = "description_list")
    private String description;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "period_type")
    @Enumerated(EnumType.STRING)
    private PeriodTypeEntity periodTypeEntity;
    @Column(name = "period")
    private Integer period;
    @Column(name = "amount_list")
    private BigDecimal amount;

    @OneToMany(mappedBy = "shopping_list",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ShoppingListItemEntity> shoppingListItemEntities;

    public ShoppingListEntity(){}
    public ShoppingListEntity(
            Long id,
            UserEntity user,
            String description,
            LocalDate date,
            PeriodTypeEntity periodTypeEntity,
            Integer period,
            BigDecimal amount) {

        this.id = id;
        this.user = user;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
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

    public PeriodTypeEntity getPeriodTypeEntity() {
        return periodTypeEntity;
    }

    public void setPeriodTypeEntity(PeriodTypeEntity periodTypeEntity) {
        this.periodTypeEntity = periodTypeEntity;
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

    public List<ShoppingListItemEntity> getShoppingListItems() {
        return shoppingListItemEntities;
    }

    public void setShoppingListItems(List<ShoppingListItemEntity> shoppingListItemEntities) {
        this.shoppingListItemEntities = shoppingListItemEntities;
    }
}
