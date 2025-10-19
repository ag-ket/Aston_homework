package com.example.demo;

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

import jakarta.validation.Valid;

@org.springframework.stereotype.Controller
@RequestMapping("/api/cats")
public class CatController {
	
        @Autowired
        private CatCarrier catCarrier;
        @Autowired
        private CatService service;

        @PostMapping
        public ResponseEntity<CatDTO> create(@Valid @RequestBody CatDTO dto) {
            CatDTO createdDTO = service.create(dto);
            return new ResponseEntity<>(createdDTO, HttpStatus.CREATED);
        }

        
        @GetMapping("/{id}")
        public ResponseEntity<CatDTO> getById(@PathVariable int id) {
            CatDTO dto = service.getById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }

        @GetMapping
        public ResponseEntity<List<CatDTO>> getAll() {
            List<CatDTO> cats = service.getAllBandits();
            return new ResponseEntity<>(cats, HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<CatDTO> update(@PathVariable int id, @Valid @RequestBody CatDTO dto) {
            CatDTO updatedDTO = service.update(id, dto);
            return new ResponseEntity<>(updatedDTO, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable int id) {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
  }
	
	


