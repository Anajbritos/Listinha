package io.ana.julia.listinha.usecase.list;

import io.ana.julia.listinha.data.ListRepository;
import io.ana.julia.listinha.data.UserRepository;
import io.ana.julia.listinha.data.dto.ListDto;
import io.ana.julia.listinha.data.mapper.ListMapper;
import io.ana.julia.listinha.data.mapper.UserMapper;
import io.ana.julia.listinha.exception.DescriptionAlreadyExistsException;
import io.ana.julia.listinha.usecase.user.CreateUserUseCaseImpl;
import io.ana.julia.listinha.utils.AssertionListData;
import io.ana.julia.listinha.utils.DataFactoryList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateListUseCaseTest {

    private ListRepository listRepository;
    private ListMapper listMapper;
    private CreateListUseCaseImpl createListUseCase;

    @BeforeEach
    void setup() {
        listRepository = Mockito.mock(ListRepository.class);
        listMapper = Mockito.mock(ListMapper.class);
        createListUseCase = new CreateListUseCaseImpl(listRepository, listMapper);
    }

    @Test
    public void givenListDTO_whenExecute_thenCreateListWithSuccess() {
        when(listRepository.existsByDescription(any())).thenReturn(false);
        when(listRepository.save(any())).thenReturn(DataFactoryList.listEntity());
        when(listMapper.toListEntity(any())).thenReturn(DataFactoryList.listEntity());
        when(listMapper.toListDTO(any())).thenReturn(DataFactoryList.listDto());

        ListDto listDto = createListUseCase.execute(DataFactoryList.listDto());
        AssertionListData.assertMapperListEquals(listDto,DataFactoryList.listDto());

        verify(listRepository).existsByDescription(any());
        verify(listRepository).save(any());
        verify(listMapper).toListEntity(any());
        verify(listMapper).toListDTO(any());
    }

    @Test
    public void givenListDTO_whenExecute_thenCreateListWithFailure() {
        when(listRepository.existsByDescription(any())).thenReturn(true);

        Assertions.assertThrows(
                DescriptionAlreadyExistsException.class,
                ()-> createListUseCase.execute(DataFactoryList.listDto()));
        verify(listRepository).existsByDescription(any());
    }
}
