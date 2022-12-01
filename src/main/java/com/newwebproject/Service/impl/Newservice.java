package com.newwebproject.Service.impl;
import com.newwebproject.DTO.NewDTO;
import com.newwebproject.Entity.CategoryEntity;
import com.newwebproject.Entity.NewEntity;
import com.newwebproject.Repository.CategoryRepository;
import com.newwebproject.Repository.NewRepository;
import com.newwebproject.Service.INewservice;
import com.newwebproject.converter.NewConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Newservice implements INewservice {
    @Autowired // gọi đến class NewRepository (nhúng)
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;
    @Override
    public NewDTO save(NewDTO newDTO) {
        NewEntity newEntity= new NewEntity();
        if (newDTO.getId() != Long.parseLong(null))
        {
            Optional<NewEntity> oldNewEntity = newRepository.findById(newDTO.getId());
            newEntity= newConverter.toEntity(newDTO);
        }else
        {
             newEntity= newConverter.toEntity(newDTO);
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());

        newEntity.setCategory(categoryEntity);
        newEntity= newRepository.save(newEntity);
        return newConverter.toDTO(newEntity);
    }
//    @Override
//    public NewDTO update( NewDTO newDTO) {
//        Optional<NewEntity> oldNewEntity = newRepository.findById(newDTO.getId());
//        NewEntity newEntity= newConverter.toEntity(newDTO,oldNewEntity);
//        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
//        newEntity.setCategory(categoryEntity);
//        newEntity= newRepository.save(newEntity);
//        return newConverter.toDTO(newEntity);
//    }


}
