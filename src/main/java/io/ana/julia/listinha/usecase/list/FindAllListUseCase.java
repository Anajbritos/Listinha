package io.ana.julia.listinha.usecase.list;

import io.ana.julia.listinha.data.dto.ListDto;

import java.util.List;

public interface FindAllListUseCase {

    List<ListDto> execute();
}
