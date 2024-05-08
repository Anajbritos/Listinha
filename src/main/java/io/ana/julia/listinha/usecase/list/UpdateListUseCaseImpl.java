package io.ana.julia.listinha.usecase.list;

import io.ana.julia.listinha.data.ListRepository;
import io.ana.julia.listinha.data.dto.ListDto;
import io.ana.julia.listinha.data.entity.ListEntity;
import io.ana.julia.listinha.data.mapper.ListMapper;
import io.ana.julia.listinha.exception.DescriptionAlreadyExistsException;
import io.ana.julia.listinha.exception.IdNotExistsException;

public class UpdateListUseCaseImpl implements UpdateListUseCase{

    private final ListRepository listRepository;
    private final ListMapper listMapper;

    public UpdateListUseCaseImpl(
            ListRepository listRepository,
            ListMapper listMapper) {
        this.listRepository = listRepository;
        this.listMapper = listMapper;
    }

    private void findListExistById(Long id) {
        if(listRepository.findById(id).isEmpty()){
            throw new IdNotExistsException("Lista não encontrada");
        }
    }

    private void findListExistByDescription(String description) {
        if(listRepository.existsByDescription(description)) {
            throw new DescriptionAlreadyExistsException("Nao é possivel fazer a atualizacao pois ja existe uma lista com esse nome");
        }
    }

    @Override
    public ListDto execute(ListDto listDto) {
        findListExistById(listDto.getId());
        findListExistByDescription(listDto.getDescription());
        ListEntity listEntity = listRepository.save(listMapper.toListEntity(listDto));
        return listMapper.toListDTO(listEntity);
    }
}
