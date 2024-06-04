package io.ana.julia.listinha.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_shopping_list_item")
public class ShoppingListItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private ShoppingListEntity shoppingList;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    public ShoppingListItemEntity() {
    }

    public ShoppingListItemEntity(
            Long id,
            ItemEntity item,
            ShoppingListEntity shoppingList
            ) {
        this.id = id;
        this.item = item;
        this.shoppingList = shoppingList;
    }

    public ShoppingListItemEntity(
            ShoppingListEntity shoppingList,
            ItemEntity item) {
        this.shoppingList = shoppingList;
        this.item = item;
    }


    public ShoppingListEntity getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingListEntity shoppingList) {
        this.shoppingList = shoppingList;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
