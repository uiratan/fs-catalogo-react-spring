package com.devsuperior.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRespository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRespository categoryRespository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = categoryRespository.findAll();
		return list.stream().map(cat -> new CategoryDTO(cat)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		 Optional<Category> obj = categoryRespository.findById(id);
		 Category entity = obj.get();
		 return new CategoryDTO(entity);
		 
	}

}