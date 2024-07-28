package com.loinguyen1905.realestate.model.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value = Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AbstractDTO<T> implements Serializable {

    private static final long serialVersionUID = 7213600440729202783L;
    private UUID id;

    @JsonFormat(pattern = "HH-mm-ss a dd-MM-yyyy", timezone = "GMT+7")
    private Instant createdDate;
    @JsonFormat(pattern = "HH-mm-ss dd-MM-yyyy a", timezone = "GMT+7")
    private Instant updatedDate;

    private String createdBy;
    private String updatedBy;

    // private int maxPageItems;
    // private int page;
    // private List<T> listResult;
    // private int totalItems;
    // private String tableId;
    // private Integer limit;
    // private Integer totalPage;
    // private Integer totalItem;
    // private String searchValue;
}