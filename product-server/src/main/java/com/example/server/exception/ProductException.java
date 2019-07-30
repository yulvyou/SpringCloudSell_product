package com.example.server.exception;



import com.example.server.enums.ResultEnum;

/**
 * 商品异常类
 */
public class ProductException extends RuntimeException{

    private Integer code;

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
