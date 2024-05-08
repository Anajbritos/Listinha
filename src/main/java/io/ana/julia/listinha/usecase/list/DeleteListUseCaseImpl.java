package io.ana.julia.listinha.usecase.list;

import io.ana.julia.listinha.data.ListRepository;
import io.ana.julia.listinha.data.mapper.ListMapper;
import io.ana.julia.listinha.exception.IdNotExistsException;
import org.springframework.stereotype.Component;

@Component
public class DeleteListUseCaseImpl implements DeleteListUseCase{

    private final ListRepository listRepository;

    public DeleteListUseCaseImpl(
            ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    private void searchExistingListById(Long id) {
        if(listRepository.findById(id).isEmpty()){
            throw new IdNotExistsException("Lista não cadastrada");
        }
    }

    @Override
    public void execute(Long id) {
        searchExistingListById(id);
        listRepository.deleteById(id);
    }
}
