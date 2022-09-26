package com.devsuperior.dscatalog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDto;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDto> findAll(){
		List<Category> list = repository.findAll();
		
		return list.stream().map(x -> new CategoryDto(x)).collect(Collectors.toList());
		
//		List<CategoryDto> listDto = new ArrayList<>();
//		for(Category cat : list) {
//			listDto.add(new CategoryDto(cat));
//		}
		
		
	}
	
}
