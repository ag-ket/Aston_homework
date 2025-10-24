package com.example.kafka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
    private UserRepository repository;
    @Autowired
    private UserService service;
    

    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO dto) {
        UserDTO createdDTO = service.create(dto);
        return new ResponseEntity<>(createdDTO, HttpStatus.CREATED);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable long id) {
        UserDTO dto = service.getById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> cats = service.getAll();
        return new ResponseEntity<>(cats, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable long id, @Valid @RequestBody UserDTO dto) {
        UserDTO updatedDTO = service.update(id, dto);
        return new ResponseEntity<>(updatedDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
    	
        service.delete(id);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @DeleteMapping()
    public ResponseEntity<Void> deleteAll()
    {
    	service.deleteAll();
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
