package me.ildar.coursework3.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.ildar.coursework3.model.SockProduct;
import me.ildar.coursework3.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Операции с товаром", description = "API для работы с товаром")
@RestController
@RequestMapping("/socks")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @Operation(summary = "Регистрация прихода", description = "Регистрирует приход товара на склад")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "удалось добавить приход"),
            @ApiResponse(responseCode = "400", description = "параметры запроса отсутствуют или имеют некорректный формат"),
            @ApiResponse(responseCode = "500", description = "произошла ошибка, не зависящая от вызывающей стороны")})
    @PostMapping
    public ResponseEntity<?> add(@RequestBody SockProduct sockProduct) {
        storeService.income(sockProduct);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Регистрация отпуска товара со склада", description = "Регистрирует отпуск товара со склада")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "удалось произвести отпуск носков со склада"),
            @ApiResponse(responseCode = "400",
                    description = "товара нет на складе в нужном количестве или параметры запроса имеют некорректный формат"),
            @ApiResponse(responseCode = "500",
                    description = "произошла ошибка, не зависящая от вызывающей стороны")})
    @PutMapping
    public ResponseEntity<?> release(@RequestBody SockProduct sockProduct) {
        storeService.release(sockProduct);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Возврат общего кол-ва носков на складе",
            description = "Возвращает общее кол-во носков на складе, соответствующих переданным в параметрах критериям запроса")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "запрос выполнен, результат в теле ответа в виде строкового представления целого числа"),
            @ApiResponse(responseCode = "400",
                    description = "параметры запроса отсутствуют или имеют некорректный формат"),
            @ApiResponse(responseCode = "500",
                    description = "произошла ошибка, не зависящая от вызывающей стороны")})
    @GetMapping
    public ResponseEntity<Integer> getCount(@RequestParam String color,
                                            @RequestParam int size,
                                            @RequestParam(required = false, defaultValue = "0") int cottonMin,
                                            @RequestParam(required = false, defaultValue = "100") int cottonMax) {
        int available = storeService.getCount(color, size, cottonMin, cottonMax);
        return ResponseEntity.ok(available);
    }

    @Operation(summary = "Списание носков", description = "Регистрирует списание испорченных (бракованных) носков.  ")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "запрос выполнен, товар списан со склада"),
            @ApiResponse(responseCode = "400",
                    description = "параметры запроса отсутствуют или имеют некорректный формат"),
            @ApiResponse(responseCode = "500",
                    description = "произошла ошибка, не зависящая от вызывающей стороны")})
    @DeleteMapping
    public ResponseEntity<?> decommission(@RequestBody SockProduct sockProduct) {
        storeService.release(sockProduct);
        return ResponseEntity.ok().build();
    }


}
