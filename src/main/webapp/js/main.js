$().ready(function() {
    $("#login_form").validate({
        rules: {
            username: "required",
            password: {
                required: true,
                minlength: 6
            },
        },
        messages: {
            username: "请输入姓名",
            password: {
                required: "请输入密码",
                minlength: "密码不能小于6个字 符"
            },
        }
    });
    $("#register_form").validate({
        rules: {
            username: "required",
            password: {
                required: true,
                minlength: 5
            },
            rpassword: {
                equalTo: "#register_password"
            }
            //,
            //email: {
            //    required: true,
            //    email: true
            //}
        },
        messages: {
            username: "请输入姓名",
            password: {
                required: "请输入密码",
                minlength: "密码不能小于5个字 符"
            },
            rpassword: {
                equalTo: "两次密码不一样"
            }
            //,
            //email: {
            //    required: "请输入邮箱",
            //    email: "请输入有效邮箱"
            //}
        }
    });
});
$(function() {
    $("#register_btn").click(function() {
        $("#register_form").css("display", "block");
        $("#login_form").css("display", "none");
    });
    $("#back_btn").click(function() {
        $("#register_form").css("display", "none");
        $("#login_form").css("display", "block");
    });
});  