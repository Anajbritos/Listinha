package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.ListDto;
import io.ana.julia.listinha.usecase.list.CreateListUseCase;
import io.ana.julia.listinha.usecase.list.DeleteListUseCase;
import io.ana.julia.listinha.usecase.list.FindAllListUseCase;
import io.ana.julia.listinha.usecase.list.UpdateListUseCase;
import io.ana.julia.listinha.usecase.user.CreateUserUseCase;
import io.ana.julia.listinha.usecase.user.DeleteUserUseCase;
import io.ana.julia.listinha.usecase.user.FindAllUsersUseCase;
import io.ana.julia.listinha.usecase.user.UpdateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListServiceImpl implements ListService{

    public CreateListUseCase createListUseCase;
    public DeleteListUseCase deleteListUseCase;
    public UpdateListUseCase updateListUseCase;
    public FindAllListUseCase findAllListUseCase;

    public ListServiceImpl(CreateListUseCase createListUseCase,
                           DeleteListUseCase deleteListUseCase,
                           UpdateListUseCase updateListUseCase,
                           FindAllListUseCase findAllListUseCase) {
        this.createListUseCase = createListUseCase;
        this.deleteListUseCase = deleteListUseCase;
        this.updateListUseCase = updateListUseCase;
        this.findAllListUseCase = findAllListUseCase;
    }

    @Override
    public ListDto createList(ListDto listDto) {
        return createListUseCase.execute(listDto);
    }

    @Override
    public void deleteList(Long id) {
        deleteListUseCase.execute(id);
    }

    @Override
    public ListDto updateList(ListDto listDto) {
        return updateListUseCase.execute(listDto);
    }

    @Override
    public List<ListDto> findAllLists() {
        return findAllListUseCase.execute();
    }
}
