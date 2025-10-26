package com.example.swagger;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<UserDTO, EntityModel<UserDTO>> {
   
	public EntityModel<UserDTO> toModel(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return EntityModel.of(userDTO,
				linkTo(methodOn(UserController.class).getById(userDTO.getId())).withSelfRel(),
                linkTo(methodOn(UserController.class).getAll()).withRel("users"));
		
	}
	
	public CollectionModel <EntityModel<UserDTO>> toCollection(List<UserDTO> entities)
	{
		List<EntityModel<UserDTO>> userModels = entities.stream()
                .map(entity -> EntityModel.of(entity,
                    linkTo(methodOn(UserController.class).getById(entity.getId())).withSelfRel(),
                    linkTo(methodOn(UserController.class).getAll()).withRel("users")))
                .collect(Collectors.toList());

            return CollectionModel.of(userModels,
                linkTo(methodOn(UserController.class).getAll()).withSelfRel());
		
	}
}
