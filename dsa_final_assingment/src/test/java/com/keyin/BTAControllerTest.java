package com.keyin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class BTAControllerTest {

    @Mock
    private BTARepository btaRepository;

    @InjectMocks
    private BTAController btaController;

    @Test
    void showEnterNumbersPage() {
        Model model = mock(Model.class);

        String result = btaController.showEnterNumbersPage(model);

        assertEquals("enter_numbers", result);
        verify(model).addAttribute(eq("previousNumbers"), any());
    }


    @Test
    void showProcessNumbersPage() {
        Model model = mock(Model.class);
        NumberEntity mockEntity = new NumberEntity();
        when(btaRepository.findFirstByOrderByIdDesc()).thenReturn(Optional.of(mockEntity));

        String result = btaController.showProcessNumbersPage(model);

        assertEquals("process_numbers", result);
        verify(model).addAttribute(eq("lastEnteredNumber"), eq(mockEntity));
    }

    @Test
    void showPreviousTreesPage() {
        Model model = mock(Model.class);

        when(btaRepository.findAll()).thenReturn(Collections.emptyList());

        String result = btaController.showPreviousTreesPage(model);

        assertEquals("previous_trees", result);
        verify(model).addAttribute(eq("treeJsonList"), any());
    }
}

//