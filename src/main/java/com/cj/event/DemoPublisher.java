package com.cj.event;

/**
 * 发布
 */
//@Component
public class DemoPublisher {

//    @Autowired
//    ApplicationContext context;

    public void published() {
        DemoEvent event = new DemoEvent(this, "发布成功！");
        System.out.println("发布event："+event);
//        context.publishEvent(event);
    }
}
