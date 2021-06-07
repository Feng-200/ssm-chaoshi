package feng.ssm.controller;

import com.github.pagehelper.PageInfo;
import feng.ssm.domain.Bumen;
import feng.ssm.domain.Category;
import feng.ssm.domain.Products;
import feng.ssm.domain.Yuangong;
import feng.ssm.service.IBumenService;
import feng.ssm.service.ICategoryService;
import feng.ssm.service.IProductsService;
import feng.ssm.service.IYuangongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/yuangong")
public class YuangongController {

    @Autowired
    private IYuangongService yuangongService;
    @Autowired
    private IBumenService bumenService;

    /**
     * 查询所有商品信息
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "5") Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Yuangong> list = yuangongService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("yuangong-list");
        return mv;
    }

    @RequestMapping("/findByName.do")
    public ModelAndView findByName(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "5") Integer size,HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView();
        String name = request.getParameter("name");
        List<Yuangong> list = yuangongService.findByName(page,size,name);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("yuangong-list");
        return mv;
    }

    @RequestMapping("/deleteYuangong.do")
    public String deleteYuangong(@RequestParam(name = "id",required = true) String id) throws Exception{
        yuangongService.delete(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deleteSelectedYuangong.do")
    public String deleteSelectedProduct(HttpServletRequest request) throws Exception{
        //1.获取所有id
        String[] ids=request.getParameterValues("uid");
        //2.调用service删除
        yuangongService.delSelectedYuangong(ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/save.do")
    public String save(Yuangong yuangong, HttpServletRequest request) throws Exception {
        yuangongService.save(yuangong);
        return "redirect:findAll.do";
    }

    @RequestMapping("/updateYuangong.do")
    public ModelAndView updateYuangong(@RequestParam(name = "id",required = true) Integer id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Yuangong yuangong = yuangongService.findById(id);
        List<Bumen> bumenList= bumenService.findBumen();
        mv.addObject("yuangongList",yuangong);
        mv.addObject("bumenList",bumenList);
        mv.setViewName("yuangong-add");
        return mv;
    }
    @RequestMapping("/update.do")
    public String update(Yuangong yuangong) throws Exception {
        yuangongService.update(yuangong);
        return "redirect:findAll.do";
    }

}
