package com.newwebproject.Service;

import com.newwebproject.DTO.NewDTO;

public interface INewservice {
    NewDTO save (NewDTO newDTO);
   // NewDTO update (NewDTO newDTO);
//   void delete (Long ids);

    void delete (long[] ids);
    NewDTO get(NewDTO newDTO);
}
