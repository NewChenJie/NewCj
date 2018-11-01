package com.cj.domain.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Excel(name = "类别",orderNum = "0")
    private  String type;
    @Excel(name = "价格",orderNum = "1")
    private Integer money;
}
