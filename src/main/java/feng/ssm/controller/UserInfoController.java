package feng.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import feng.ssm.domain.UserInfo;
import feng.ssm.service.IUserInfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 登录功能
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping("/login.do")
    public ModelAndView login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String checkcode = request.getParameter("checkcode");
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");//确保验证码一次性
        if (!checkcode_server.equalsIgnoreCase(checkcode)) {
            //验证码不正确
            //提示信息
            mv.addObject("msg", "验证码错误");
            mv.setViewName("login");
        } else {
            UserInfo userInfo = userInfoService.findByName(username);
            if (userInfo != null) {
                String password1 = userInfo.getPassword();
                if (password.equals(password1)) {
                    session.setAttribute("userInfo", userInfo);
                    mv.setViewName("main");
                } else {
                    mv.addObject("msg", "用户名或密码错误");
                    mv.setViewName("login");
                }
            } else {
                mv.addObject("msg", "用户名或密码错误");
                mv.setViewName("login");
            }
        }
        return mv;
    }

    /**
     * 注册管理员账号
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public ModelAndView save(UserInfo userInfo) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo info = userInfoService.findByName(userInfo.getUsername());
        System.out.println(info);
        if (info==null){
            userInfoService.save(userInfo);
            mv.setViewName("main");
        }else {
            mv.addObject("cuowu", "管理员已存在！");
            mv.setViewName("register");
        }
        /*userInfoService.save(userInfo);
        mv.setViewName("main");*/
        return mv;
    }


    @RequestMapping("/updatePassword.do")
    public String updatePassword(HttpServletRequest request) throws Exception {
        //获取session
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        String oldPassword = userInfo.getPassword();

        //获取用户输入的原密码
        String password = request.getParameter("password");
        //用户输入的新密码
        String newPassword = request.getParameter("newPassword");
        String newUsername = request.getParameter("newUsername");
        String newPeopleName = request.getParameter("newPeopleName");
        String newPhoneNume = request.getParameter("newPhoneNume");
        if (password.equals(oldPassword)) {
            userInfo.setUsername(newUsername);
            userInfo.setPassword(newPassword);
            userInfo.setPeopleName(newPeopleName);
            userInfo.setPhoneNume(newPhoneNume);
            //如果输入原密码正确就修改密码
            userInfoService.update(userInfo);
            return "login";
        } else {
            //如果不存在 提示密码不正确
            session.setAttribute("result", "原密码不正确");
        }
        return "updatePassword";
    }


}
