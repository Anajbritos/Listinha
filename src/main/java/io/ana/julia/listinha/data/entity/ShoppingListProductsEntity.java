package io.ana.julia.listinha.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_shopping_list_product")
public class ShoppingListProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private ShoppingListEntity shoppingList;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    public ShoppingListProductEntity() {
    }

    public ShoppingListProductEntity(
            Long id,
            ProductEntity product,
            ShoppingListEntity shoppingList
            ) {
        this.id = id;
        this.product = product;
        this.shoppingList = shoppingList;
    }

    public ShoppingListProductEntity(
            ShoppingListEntity shoppingList,
            ProductEntity product) {
        this.shoppingList = shoppingList;
        this.product = product;
    }


    public ShoppingListEntity getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingListEntity shoppingList) {
        this.shoppingList = shoppingList;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
