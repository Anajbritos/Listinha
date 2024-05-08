package io.ana.julia.listinha.usecase.list;

import io.ana.julia.listinha.data.ListRepository;
import io.ana.julia.listinha.data.dto.ListDto;
import io.ana.julia.listinha.data.entity.ListEntity;
import io.ana.julia.listinha.data.mapper.ListMapper;
import io.ana.julia.listinha.exception.DescriptionAlreadyExistsException;
import org.springframework.stereotype.Component;

@Component
public class CreateListUseCaseImpl implements CreateListUseCase{

    private final ListRepository listRepository;
    private final ListMapper listMapper;

    public CreateListUseCaseImpl(
            ListRepository listRepository,
            ListMapper listMapper) {
        this.listRepository = listRepository;
        this.listMapper = listMapper;
    }

    private void findListExistByDescription(String description){
        if(listRepository.existsByDescription(description)){
            throw new DescriptionAlreadyExistsException("Lista já existente com essa descricao");
        }
    }

    @Override
    public ListDto execute(ListDto listDto) {
        findListExistByDescription(listDto.getDescription());
        ListEntity listEntity = listRepository.save(listMapper.toListEntity(listDto));
        return listMapper.toListDTO(listEntity);
    }
}
