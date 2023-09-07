package com.qfedu.sys.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.qfedu.sys.constant.sysConstant;
import com.qfedu.sys.domain.User;
import com.qfedu.sys.domain.UserVo;
import com.qfedu.sys.service.loginService;
import com.qfedu.sys.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class  longinController {

    @Autowired
    private loginService loginService;
    @RequestMapping("toLogin")
    public String toLogin(){
        return "system/main/login";
    }
    /*
    生成验证码
    * */
    @RequestMapping("getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        //定义图形长度宽度和符号和干扰线
     LineCaptcha lineCaptcha= CaptchaUtil.createLineCaptcha(116,36,4,5);
     //生成的验证码放到session中
     session.setAttribute("code",lineCaptcha.getCode());
     //获取输出流
        ServletOutputStream outputStream =response.getOutputStream();
        //  将数据以图片的方式输出
        ImageIO.write(lineCaptcha.getImage(),"JPEG",outputStream);
    }
    @RequestMapping("login")
    public String login(UserVo userVo, Model model){
        //获取验证码
        String code=WebUtils.getHttpSession().getAttribute("code").toString();
        //判断验证码
        if(userVo.getCode().equals(code)){
            User user=loginService.login(userVo);
            if(user!=null){
                //用户登录成功
                WebUtils.getHttpSession().setAttribute("user",user);
                return "system/main/index";
            }else{
                //没有查到用户
                model.addAttribute("error", sysConstant.USER_LOGIN_ERROR_MSG);
                return "system/main/login";
            }
        }else{
            model.addAttribute("error",sysConstant.USER_LOGIN_CODE_ERROR_MSG);
            return "system/main/login";
        }
    }
}
