package com.example.kafka;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	@Autowired
	private KafkaTemplate <String, String> template;
	
	UserDTO create(UserDTO dto)
	{
		User user = toEntity(dto);
		User savedUser = repository.save(user);
		template.send("create", savedUser.getEmail());
		return toDTO(savedUser);
		
	}
	
	UserDTO getById(long id)
	{
		User user = repository.findById(id).orElseThrow(()-> new NullPointerException("Пользователя не существует"));
        return toDTO(user);
		
	}
	
	List <UserDTO> getAll()
	{
		 List<User> users = repository.findAll();
	        return users.stream()
	                .map(user -> toDTO(user))
	                .collect(Collectors.toList());
		
	}
	
	UserDTO update (long id, UserDTO dto)
	{
		User user = repository.findById(id).orElseThrow(()-> new NullPointerException("Пользователя не существует"));
		user.setName(dto.getName());
		user.setAge(dto.getAge());
		user.setEmail(dto.getEmail());
		User updatedUser = repository.save(user);
		return toDTO(updatedUser);
		
	}
	
	void delete(long id)
	{
		User user = repository.findById(id).get();
		template.send("delete", user.getEmail());
		repository.deleteById(id);
		
	}
	
	void deleteAll()
	{
		repository.deleteAll();
	}
	
	User toEntity(UserDTO dto) {
		
		User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());

        
        return user;
    }
	
	UserDTO toDTO(User user)
	{
		UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setAge(user.getAge());
        dto.setEmail(user.getEmail());
        return dto;
	}
	
	

}
