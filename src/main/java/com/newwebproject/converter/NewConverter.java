package com.newwebproject.converter;

import com.newwebproject.DTO.NewDTO;
import com.newwebproject.Entity.NewEntity;
import org.springframework.stereotype.Component;

//nhúng vào newservice
@Component // dependence injection đối với class nào đó
public class NewConverter {
    //convert data từ newdto wa entity
    public NewEntity toEntity(NewDTO dto){
        NewEntity entity=new NewEntity();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDescription(dto.getShortDescriptionn());
        entity.setThumbnail(dto.getThumnail());
        return entity;
    }
    public NewDTO toDTO(NewEntity entity){
        NewDTO dto=new NewDTO();
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setShortDescriptionn(entity.getShortDescription());
        dto.setThumnail(entity.getThumbnail());
        return dto;
    }

    public NewEntity toEntity(NewDTO dto, NewEntity entity){

        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDescription(dto.getShortDescriptionn());
        entity.setThumbnail(dto.getThumnail());
        return entity;
    }
}
