package com.cj.domain.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    @Excel(name = "类别",orderNum = "0")
    private  String type;
    @Excel(name = "价格",orderNum = "1")
    private Integer money;
}
