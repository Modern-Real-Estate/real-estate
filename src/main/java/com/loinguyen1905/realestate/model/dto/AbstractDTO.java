package com.loinguyen1905.realestate.model.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractDTO<T> implements Serializable {
    private static final long serialVersionUID = 7213600440729202783L;
    private UUID id;
    // private Date createdDate;
    // private String createdBy;
    // private Date modifiedDate;
    // private String modifiedBy;
    // private int maxPageItems = 3;
    // private int page = 1;
    // private List<T> listResult = new ArrayList<>();
    // private int totalItems = 0;
    // private String tableId = "tableList";
    // private Integer limit;
    // private Integer totalPage;
    // private Integer totalItem;
    // private String searchValue;
}