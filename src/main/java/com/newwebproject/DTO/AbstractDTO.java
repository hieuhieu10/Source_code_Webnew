package com.newwebproject.DTO;

import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class AbstractDTO<T> {
        private Long id;
        private String createdBy;
        private Instant createdDate;
        private String modifiedBy;
        private Instant modifiedDate;
        private List<T> listResult = new ArrayList<>();

}
