package com.newwebproject.DTO;

import lombok.Data;

@Data
public class NewDTO extends AbstractDTO<NewDTO> { //<NewDTO> làm việc với <NewDTO> trả về list của <NewDTO>
    private String title;
    private String content;
    private String shortDescriptionn;
    private String categoryCode;
    private String thumnail;
}
