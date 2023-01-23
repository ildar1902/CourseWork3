package me.ildar.coursework3.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.ildar.coursework3.model.Sock;
import me.ildar.coursework3.service.SockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Операции с товаром", description = "API для работы с товаром")
@RestController
@RequestMapping("/socks")
public class SockController {
    private final SockService sockService;

    public SockController(SockService sockService) {
        this.sockService = sockService;
    }
    @Operation(summary = "Регистрация прихода", description = "Регистрирует приход товара на склад")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "удалось добавить приход"),
        @ApiResponse(responseCode = "400", description = "параметры запроса отсутствуют или имеют некорректный формат"),
        @ApiResponse(responseCode = "500", description = "произошла ошибка, не зависящая от вызывающей стороны")

    })
    @PostMapping
    public String add(@RequestBody Sock sock) {
        return sockService.add(sock);
    }
}
