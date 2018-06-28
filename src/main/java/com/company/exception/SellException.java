package com.company.exception;

import com.company.enums.ResultEnum;

/**
 * Created by hu on 2018-06-28.
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
