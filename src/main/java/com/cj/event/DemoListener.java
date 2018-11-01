package com.cj.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

//@Component
@Slf4j
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
       log.info("接收到：{}",msg);
    }
}
