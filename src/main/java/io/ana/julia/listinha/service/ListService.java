package io.ana.julia.listinha.service;

import io.ana.julia.listinha.data.dto.ListDto;

import java.util.List;

public interface ListService {

    public ListDto createList(ListDto listDto);
    public void deleteList(Long id);
    public ListDto updateList(ListDto listDto);
    public List<ListDto> findAllLists();
}
