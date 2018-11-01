package com.cj.junit;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.cj.domain.dto.Book;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Slf4j
public class JunitTest {
private  static Map<String,Function<Book,Boolean>> map=new HashMap<>();
static {
    map.put("Java", JunitTest::runOne);
    map.put("tow", JunitTest::runTwo);
}

    private static Boolean runTwo(Book x) {
        log.info("runOne{}",x.getName());
        return true;
    }

    private static Boolean runOne(Book x) {
        log.info("runTwo{}",x.getName());
        return  false;
    }

    @Test
    public void testOptional(){
         val book= Book.builder().name("Java").build();
        map.forEach((x,v)->{
             if (x.equals(book.getName())){
                  v.apply(book);
             } });
    }

    @Test
    public void fe_map() throws Exception {
        TemplateExportParams params = new TemplateExportParams(
                "临沂客户做单详情.xls");
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("date", "2014-12-25");
//        map.put("money", 2000000.00);
//        map.put("upperMoney", "贰佰万");
        map.put("name", "执笔潜行科技有限公司");
        map.put("what", "财政局");
//        map.put("person", "JueYue");
//        map.put("phone", "1879740****");
//        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
//        for (int i = 0; i < 4; i++) {
//            Map<String, String> lm = new HashMap<String, String>();
//            lm.put("id", i + 1 + "");
//            lm.put("zijin", i * 10000 + "");
//            lm.put("bianma", "A001");
//            lm.put("mingcheng", "设计");
//            lm.put("xiangmumingcheng", "EasyPoi " + i + "期");
//            lm.put("quancheng", "开源项目");
//            lm.put("sqje", i * 10000 + "");
//            lm.put("hdje", i * 10000 + "");
//
//            listMap.add(lm);
//        }
//        map.put("maplist", listMap);

        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        File savefile = new File("D:/excel/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:/excel/临沂客户做单详情.xls");
        workbook.write(fos);
        fos.close();
    }
    @Test
    public void testAccess() throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 =sdf1 .parse("2018-01-01");
        Calendar calendar1 = Calendar.getInstance();
        //calendar1.setTime(new Date());
        //calendar1.add(Calendar.DAY_OF_MONTH, -2);
        calendar1.setTime(date1);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.add(Calendar.DAY_OF_MONTH, -1);

        String startTime = sdf1.format(calendar1.getTime());
        String endTime = sdf1.format(calendar2.getTime());
        System.out.println(startTime);
        System.out.println(endTime);

    }

}
