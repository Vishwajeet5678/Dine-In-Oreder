package com.example.dine_in_order.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponseStructure<T> {
    private int status;
    private String message;
    private T data;
    public static <T>ResponseStructure<T> create(HttpStatus status,String message,T data)
    {
        ResponseStructure<T> res=new ResponseStructure<T>();
        res.status=status.value();
        res.message=message;
        res.data=data;
        return res;
    }

}
