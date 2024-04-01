package com.example.testhr;

import com.example.testhr.Controllers.MainController;
import com.example.testhr.DTO.UserDTO;
import com.example.testhr.Entyties.User;
import com.example.testhr.Service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MainControllerTest {

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private MainController mainController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserById() {
        Long userId = 1L;
        UserDTO expectedUserDTO = new UserDTO(27L, "Danil12w3", "12141@mail.ru", "Danil", "bildeikin", 12);
        when(userService.getUserById(userId)).thenReturn(expectedUserDTO);

        ResponseEntity<UserDTO> actualResponse = mainController.getUserById(userId);

        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(expectedUserDTO, actualResponse.getBody());
    }

    @Test
    public void testDeleteUserById() {
        Long userId = 27L;

        ResponseEntity<?> actualResponse = mainController.deleteUserById(userId);

        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals("Пользователь успешно удален", actualResponse.getBody());
    }
}
