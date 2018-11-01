package com.cj.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 测试rabbitmq使用
 * @author Administrator
 */
@Data
@Builder
@Accessors(chain = true)
public class Book implements Serializable{
    private static final long serialVersionUID = -2164058270260403154L;

    private String id;
    private String name;
}
