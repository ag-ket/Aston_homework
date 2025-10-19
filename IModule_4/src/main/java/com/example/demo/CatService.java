package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatService {
	

	@Autowired
	private CatCarrier catCarrier;
	

	
	public CatDTO create(CatDTO dto)
	{
		BanditCat cat = convertEntity(dto);
		BanditCat savedCat = catCarrier.save(cat);
		return convertDTO(savedCat);
	}
	
	public CatDTO getById(int id) {
        BanditCat cat = catCarrier.findById(id).orElseThrow(()-> new NullPointerException("Нет в базах данных"));
        return convertDTO(cat);
    }

    public List<CatDTO> getAllBandits() {
        List<BanditCat> cats = catCarrier.findAll();
        return cats.stream()
                .map(this::convertDTO)
                .collect(Collectors.toList());
        
    }

    public CatDTO update(int id, CatDTO dto) {
        BanditCat cat = catCarrier.findById(id).orElseThrow(()-> new NullPointerException("Нет в базах данных"));
        cat.setName(dto.getName());
        cat.setNickname(dto.getNickname());
        cat.setMalice(dto.getMalice());
        BanditCat updatedCat = catCarrier.save(cat);
        return convertDTO(updatedCat);
    }

    public void delete(int id) {
        catCarrier.deleteById(id);
    }
    
    public BanditCat convertEntity(CatDTO dto) {
        BanditCat cat = new BanditCat(dto.getId(), dto.getName(), dto.getNickname(), dto.getMalice());
        return cat;
    }
    
    private CatDTO convertDTO(BanditCat cat) {
        CatDTO dto = new CatDTO(cat.getId(), cat.getName(), cat.getNickname(), cat.getMalice());
        return dto;
    }
}
	
	


