package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.ListDto;

import java.util.List;

public interface ListService {

    ListDto createList(ListDto listDto);
    void deleteList(Long id);
    ListDto updateList(ListDto listDto);
    List<ListDto> findAllLists();
}
