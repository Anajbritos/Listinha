package io.ana.julia.listinha.data.dto;

public class ShoppingListItemDto {

    private Long id;
    private ItemDto item;
    private ShoppingListDto shoppingListDto;

    public ShoppingListItemDto(){}
    public ShoppingListItemDto(
            Long id,
            ItemDto item,
            ShoppingListDto shoppingListDto) {
        this.id = id;
        this.item = item;
        this.shoppingListDto = shoppingListDto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public ItemDto getItem() {
        return item;
    }

    public void setItem(ItemDto item) {
        this.item = item;
    }
    public ShoppingListDto getShoppingListDto() {
        return shoppingListDto;
    }

    public void setShoppingListDto(ShoppingListDto shoppingListDto) {
        this.shoppingListDto = shoppingListDto;
    }
}
