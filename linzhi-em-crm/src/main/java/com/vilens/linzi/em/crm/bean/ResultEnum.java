/**
 *
 */
package com.vilens.linzi.em.crm.bean;

/**
 * 定义返回值的一些指定类型
 *
 * @author Wesley
 */
public enum ResultEnum {

    error(0), success(1), warn(2), none(3), auth(1001);

    private Integer result;

    private ResultEnum(Integer value) {
        this.result = value;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

}
