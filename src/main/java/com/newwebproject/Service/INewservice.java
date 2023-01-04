package com.newwebproject.Service;

import com.newwebproject.DTO.NewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewservice {
    NewDTO save (NewDTO newDTO);
    void delete (long[] ids);
    NewDTO get(Long id);
    List<NewDTO> getAllDto ();
    Page<NewDTO> getAllDto (Pageable pageable);
    Page<NewDTO> getByCategory (Pageable pageable,Long id);
}
