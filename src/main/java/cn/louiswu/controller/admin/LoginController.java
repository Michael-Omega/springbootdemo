package cn.louiswu.controller.admin;

import cn.louiswu.bean.result.Result;
import cn.louiswu.controller.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class LoginController extends BaseController {

    @PostMapping("/adminLogin")
    public Result adminLogin(){
        Result result = new Result();
        return result;
    }
}
