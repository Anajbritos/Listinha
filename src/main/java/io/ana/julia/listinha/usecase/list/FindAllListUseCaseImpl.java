package io.ana.julia.listinha.usecase.list;

import io.ana.julia.listinha.data.ListRepository;
import io.ana.julia.listinha.data.dto.ListDto;
import io.ana.julia.listinha.data.mapper.ListMapper;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllListUseCaseImpl implements FindAllListUseCase {

    private final ListRepository listRepository;
    private final ListMapper listMapper;

    public FindAllListUseCaseImpl(
            ListRepository listRepository,
            ListMapper listMapper) {
        this.listRepository = listRepository;
        this.listMapper = listMapper;
    }

    @Override
    public List<ListDto> execute() {
        return listRepository.
                findAll().
                stream().
                map(listEntity -> listMapper.toListDTO(listEntity)).
                collect(Collectors.toList());
    }
}
