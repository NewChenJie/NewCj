package com.cj.domain;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import com.cj.domain.dto.Man;

public class UserExcelHandler  extends ExcelDataHandlerDefaultImpl<Man> {
    /**
     * 导入处理 对导入的数据姓名后面都加上  测试
     * @param obj
     * @param name
     * @param value
     * @return
     */
    @Override
    public Object importHandler(Man obj, String name, Object value) {
        return super.importHandler(obj, name, value.toString()+"测试");
    }
}
