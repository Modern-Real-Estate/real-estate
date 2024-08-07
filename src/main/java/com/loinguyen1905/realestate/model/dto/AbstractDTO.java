package com.loinguyen1905.realestate.model.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

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
    // @JsonFormat(pattern = "HH-mm-ss a dd-MM-yyyy", timezone = "GMT+7")
    private String createdDate;
    // @JsonFormat(pattern = "HH-mm-ss a dd-MM-yyyy", timezone = "GMT+7")
    private String updatedDate;
    private String createdBy;
    private String updatedBy;
    private Integer maxPageItems;
    private Integer page;
    private Integer size;
    @Order(Ordered.HIGHEST_PRECEDENCE)
    private List<T> content;
    private Integer totalElements;
    private Integer totalPages;
    // private String tableId;
    // private Integereger limit;
    // private Integereger totalItem;
    // private String searchValue;
}