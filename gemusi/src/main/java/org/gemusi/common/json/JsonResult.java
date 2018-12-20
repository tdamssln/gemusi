package org.gemusi.common.json;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@Component
@Scope("prototype")
public class JsonResult implements Serializable {
    private static final long serialVersionUID = 1L;

    public JsonResult() {
    }

    public JsonResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    /**
     * 用于重置当前json对象
     *
     * @return
     */
    public JsonResult reset() {
        this.success = null;
        this.statusCode = null;
        this.message = null;
        this.errors = null;
        this.rows = null;
        this.total = null;
        return this;
    }
    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 状态码
     */
    private Integer statusCode;

    /**
     * 信息
     */
    private String message;

    /**
     * 封装多个 错误信息
     */
    private Map<String, Object> errors;


    /**
     * 数据
     */
    private Object rows;

    /**
     * 本次查询出的数据量
     */
    private Long total;

    private Map map;

    public Boolean isSuccess() {
        return success;
    }

    public JsonResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public JsonResult setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public JsonResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map<String, Object> getErrors() {
        return errors;
    }

    public JsonResult setErrors(Map<String, Object> errors) {
        this.errors = errors;
        return this;
    }


    public Object getRows() {
        return rows;
    }

    public JsonResult setRows(Object data) {
        this.rows = data;
        return this;
    }

    public Object getMap() {
        return map;
    }

    public JsonResult setMap(Object key, Object value) {
        if (this.map == null) {
            this.map = new HashMap();
        }
        this.map.put(key, value);
        return this;
    }


    public Long getTotal() {
        return total;
    }

    public JsonResult setTotal(long total) {
        this.total = total;
        return this;
    }


}
