package com.cj.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class DemoEvent extends ApplicationEvent {

    private String msg;


    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg=msg;
    }
}
