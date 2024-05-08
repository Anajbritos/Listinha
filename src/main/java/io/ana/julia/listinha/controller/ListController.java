package io.ana.julia.listinha.controller;

import io.ana.julia.listinha.data.dto.ListDto;
import io.ana.julia.listinha.service.ListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ListController {

    private ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @PostMapping("/create")
    public ResponseEntity<ListDto> createList(@RequestBody ListDto listDto) {
        ListDto requestBody = listService.createList(listDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(requestBody);
    }

    @DeleteMapping("/delete/{}")
    public ResponseEntity<Void> deleteList(@PathVariable Long id) {
        listService.deleteList(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/update")
    public ResponseEntity<ListDto> updateList(@RequestBody ListDto listDto) {
        ListDto requestBody = listService.updateList(listDto);
        return ResponseEntity.status(HttpStatus.OK).body(requestBody);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<ListDto>> findAllList() {
        List<ListDto> requestBody = listService.findAllLists();
        return ResponseEntity.status(HttpStatus.OK).body(requestBody);
    }
}
