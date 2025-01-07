package com.jiuzhou.desgin.excel.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 */
@Data
public class ImportResDTO implements Serializable {

    private static final long serialVersionUID = -4577699748290750945L;

    private int total = 0;

    private int fail = 0;

    private int succ= 0;

    private String serviceId;

    private Map<Object,Object> errorMap = new HashMap<>();

}
