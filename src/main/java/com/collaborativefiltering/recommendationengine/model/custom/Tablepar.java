package com.collaborativefiltering.recommendationengine.model.custom;

import lombok.Data;

@Data
public class Tablepar {

    private String searchText;
    
    // 当前页数
    private int pageNum = 1;
    
    // 每页显示条数
    private int pageSize = 10;
}
