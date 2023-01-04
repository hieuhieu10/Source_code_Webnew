package com.newwebproject.Service.impl;

import com.newwebproject.DTO.NewDTO;
import com.newwebproject.Entity.CategoryEntity;
import com.newwebproject.Entity.NewEntity;
import com.newwebproject.Repository.CategoryRepository;
import com.newwebproject.Repository.NewRepository;
import com.newwebproject.Service.INewservice;
import com.newwebproject.converter.NewConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
            newEntity.setCreatedDate(Instant.now());
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        newEntity= newRepository.save(newEntity);
        return newConverter.toDTO(newEntity);
    }
    @Override
    public void delete(long[] ids) {
        for (long item:ids) {
            newRepository.deleteById(item);
        }
    }

    @Override
    public NewDTO get(Long id) {
       NewEntity newEntity= newRepository.findById(id).get();
       return newConverter.toDTO(newEntity);
       // return newConverter.toDTO(newEntity1);
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
    public List<NewDTO>  getAllDto (){
        List <NewEntity> entities = newRepository.findAll();
        List <NewDTO> newDTOS= new ArrayList<>();
        for (NewEntity entity: entities)
        {
            newDTOS.add(newConverter.toDTO(entity));
        }
        return newDTOS;
    }
    public Page<NewDTO> getAllDto (Pageable pageable){
        List <NewEntity> entities = newRepository.findAll();
        List <NewDTO> newDTOS= new ArrayList<>();
        for (NewEntity entity: entities)
        {
            newDTOS.add(newConverter.toDTO(entity));
        }
        final int start = (int)pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), newDTOS.size());
        final Page<NewDTO> page = new PageImpl<>(newDTOS.subList(start, end), pageable, newDTOS.size());
        return  page;
    }

    public Page<NewDTO> getByCategory (Pageable pageable, Long id){
        List <NewEntity> entities = newRepository.findByCategory(id);
        List <NewDTO> newDTOS= new ArrayList<>();
        for (NewEntity entity: entities)
        {
            newDTOS.add(newConverter.toDTO(entity));
        }
        final int start = (int)pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), newDTOS.size());
        final Page<NewDTO> page = new PageImpl<>(newDTOS.subList(start, end), pageable, newDTOS.size());
        return  page;
    }
}
