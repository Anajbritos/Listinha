package io.ana.julia.listinha.usecase.shoppinglist;

public interface AddItemOnShoppingListUseCase {

    public void execute(Long user, Long item, Long list);
}
