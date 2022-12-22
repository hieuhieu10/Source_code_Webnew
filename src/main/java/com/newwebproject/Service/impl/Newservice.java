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

@Service
public class Newservice implements INewservice {
    @Autowired // gọi đến class NewRepository (nhúng)
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;
    @Override
//    public NewDTO save(NewDTO newDTO) {
//        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
//        NewEntity newEntity= newConverter.toEntity(newDTO);
//        newEntity.setCategory(categoryEntity);
//        newEntity= newRepository.save(newEntity);
//        return newConverter.toDTO(newEntity);
//    }
    public NewDTO save(NewDTO newDTO) {
        NewEntity newEntity= new NewEntity();
        if (newDTO.getId() != null)
        {
            NewEntity oldNewEntity = newRepository.findById(newDTO.getId()).get();
            newEntity= newConverter.toEntity(newDTO,oldNewEntity);
        }else {
            newEntity = newConverter.toEntity(newDTO);// converter nguyen ban Entity
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());

        newEntity.setCategory(categoryEntity);
        newEntity= newRepository.save(newEntity);
        return newConverter.toDTO(newEntity);
    }

//    @Override
//    public void delete(Long ids) {
//        newRepository.deleteById(ids);
//    }


    @Override
    public void delete(long[] ids) {
        for (long item:ids) {
            newRepository.deleteById(item);
        }
    }

    @Override
    public NewDTO get(NewDTO newDTO) {
        CategoryEntity categoryEntity = categoryRepository.findById(newDTO.getId()).get();
        NewEntity newEntity= newConverter.toEntity(newDTO);
        newEntity.setCategory(categoryEntity);
       // newEntity= newRepository.getReferenceById(newDTO.getId());
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
