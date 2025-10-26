package com.example.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Контроллер пользователя", description = "Основные методы для работы с базой данных")
@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
    private UserRepository repository;
    @Autowired
    private UserService service;
    @Autowired
    private UserModelAssembler assembler;
    

    @Operation(summary="Создание пользователя", description="Используется для создания пользователя")
    @PostMapping
    public ResponseEntity<EntityModel<UserDTO>> create(@Valid @RequestBody UserDTO dto) {
        return ResponseEntity.ok(assembler.toModel(service.create(dto)));
    }

    @Operation(summary="Поиск пользователя", description="Используется для поиска пользователя по идентификатору")
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<UserDTO>> getById(@PathVariable @Parameter(description="Идентификатор искомого пользователя") long id) {
        return ResponseEntity.ok(assembler.toModel(service.getById(id)));
    }

    @Operation(summary="Поиск пользователей", description="Используется для вывода всех зарегистрированных пользователей")
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<UserDTO>>> getAll() {
        return ResponseEntity.ok(assembler.toCollection(service.getAll()));
    }

    @Operation(summary="Изменение пользователя", description="Используется для изменения существующего пользователя")
    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<UserDTO>> update(@PathVariable @Parameter(description="Идентификатор изменяемого пользователя") long id, @Valid @RequestBody UserDTO dto) {
        return ResponseEntity.ok(assembler.toModel(service.update(id, dto)));
    }

    @Operation(summary="Удаление пользователя", description="Используется для удаления пользователя")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Parameter(description="Идентификатор удаляемого пользователя") long id) {
    	
        service.delete(id);
        return ResponseEntity.ok().build();
        
    }
    
    @Operation(summary="Удаление всех пользователей", description="Используется для удаления всех пользователей из базы данных")
    @DeleteMapping()
    public ResponseEntity<Void> deleteAll()
    {
    	service.deleteAll();
    	return ResponseEntity.ok().build();
    }

}
