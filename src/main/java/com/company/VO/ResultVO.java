package com.company.VO;

import lombok.Data;

/**
 * Created by hu on 2018-06-28.
 */
@Data
public class ResultVO<T> {

    /**状态码*/
    private Integer code;

    /**消息*/
    private String msg;

    /**数据*/
    private Object data;
}
