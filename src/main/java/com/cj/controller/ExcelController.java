package com.cj.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import com.cj.domain.UserExcelHandler;
import com.cj.domain.dto.Car;
import com.cj.domain.dto.Man;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/demo")
@Slf4j
public class ExcelController {

    @RequestMapping("/excel")
    public void excelDemo(HttpServletResponse response)throws Exception {
        // 设置响应输出的头类型
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=staff.xls");
        // =========easypoi部分
        ExportParams exportParams = new ExportParams();
        // exportParams.setDataHanlder(null);//和导入一样可以设置一个handler来处理特殊数据
        ArrayList<Man> men = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(Car.builder().type("汽车").money(999).build());
        cars.add(Car.builder().type("货车").money(888).build());
        men.add(Man.builder().name("张三").age(18).build());
        men.add(Man.builder().name("格有").age(25).build());

        HashMap<String, Object> carMap = new HashMap<>();
        carMap.put("title",exportParams);
        carMap.put("entity",Car.class);
        carMap.put("data",cars);

        HashMap<String, Object> userMap = new HashMap<>();
        userMap.put("title",exportParams);
        userMap.put("entity",Man.class);
        userMap.put("data", men);

        List<Map<String,Object>> excel = Arrays.asList(carMap,userMap);
        Workbook workbook = ExcelExportUtil.exportExcel(excel,ExcelType.HSSF);
        workbook.setSheetName(0,"car");
        workbook.setSheetName(1,"user");
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
    }
    @RequestMapping("/import")
    public void excelImport(@RequestParam("file") MultipartFile file) throws Exception {
        ImportParams importParams = new ImportParams();
        IExcelDataHandler<Man> handler = new UserExcelHandler();
        // 注意这里对应的是excel的列名。也就是对象上指定的列名
        handler.setNeedHandlerFields(new String[] { "姓名" });
        importParams.setDataHanlder(handler);
        // 开启验证
        importParams.setNeedVerfiy(true);
        ExcelImportResult<Man> result = ExcelImportUtil.importExcelMore(file.getInputStream(), Man.class, importParams);
        //导入成功的list
        List<Man> successList = result.getList();
        //导入失败的list
        List<Man> failList = result.getFailList();
        System.out.println(successList);
        System.out.println(failList);
        log.info("验证通过的数量:" + successList.size());
        log.info("验证未通过的数量:" + failList.size());


    }
    @GetMapping("/export")
    @SneakyThrows
    public void export(HttpServletResponse response) {
            // 设置响应输出的头类型
            response.setHeader("content-Type", "application/vnd.ms-excel");
            // 下载文件的默认名称
            response.setHeader("Content-Disposition", "attachment;filename=user.xlsx");
            // =========easypoi部分
            ExportParams exportParams = new ExportParams();
            // exportParams.setDataHanlder(null);//和导入一样可以设置一个handler来处理特殊数据
            Workbook workbook = ExcelExportUtil.exportExcel(exportParams, Man.class, null);
            workbook.write(response.getOutputStream());

    }

}
