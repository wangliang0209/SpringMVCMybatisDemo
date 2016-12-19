/**
 *
 */
package com.wl.base.common;

/**
 * 类名称：	CodeConstans
 * 类描述：	编码枚举对象
 *
 * @version 1.0.0
 */
public enum CodeConstans {

    AJAX_SESSION_TIMEOUT(10001, "会话超时"),
    AJAX_ERROR_403(403, "无权限，拒绝访问"),

    SUCCESS_0(0, "成功"),
    ERROR_403(403, "无权限，拒绝访问"),
    ERROR_404(404, "不存在此服务"),
    ERROR_500(500, "服务端发生未知错误"),
    ERROR_501(501, "服务端异常无法进行支付"),
    NOT_LOGIN_ERROR_1000(1000, "尚未登录"),
    UPLOAD_FILE_ERROR_1100(1100, "上传文件失败"),
    LOAD_DICT_ERROR_1200(1200, "加载字典失败"),
    INPUT_PARAMS_BLANK_1300(1300, "输入参数有误"),
    QUERY_ERROR_1400(1400, "查询信息失败");

    private CodeConstans(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 消息编码
     */
    private final int code;

    /**
     * 消息描述
     */
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
