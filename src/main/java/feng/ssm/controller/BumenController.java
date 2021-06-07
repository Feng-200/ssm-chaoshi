package feng.ssm.controller;

import com.github.pagehelper.PageInfo;
import feng.ssm.domain.Bumen;
import feng.ssm.domain.Category;
import feng.ssm.service.IBumenService;
import feng.ssm.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/bumen")
public class BumenController {

    @Autowired
    private IBumenService bumenService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "5") Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Bumen> list = bumenService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("bumen-list");
        return mv;
    }

    @RequestMapping("/findByBumenName")
    public ModelAndView findByName(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "5") Integer size, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView();
        String name = request.getParameter("name");
        List<Bumen> list = bumenService.findByName(page,size,name);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("bumen-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Bumen bumen) throws Exception {
        bumenService.save(bumen);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findBumenToYuangongAdd.do")
    public ModelAndView findBumenToYuangongAdd() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Bumen> list = bumenService.findBumen();
        mv.addObject("bumenList",list);
        mv.setViewName("yuangong-add");
        return mv;
    }

    @RequestMapping("/deleteBumen.do")
    public String deleteBumen(@RequestParam(name = "id",required = true) Integer id) throws Exception{
        bumenService.delete(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/updateBumen.do")
    public ModelAndView updateBumen(@RequestParam(name = "id",required = true) Integer id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Bumen bumen = bumenService.findById(id);
        mv.addObject("bumen",bumen);
        mv.setViewName("bumen-add");
        return mv;
    }

    @RequestMapping("/update.do")
    public String update(Bumen bumen) throws Exception {
        bumenService.update(bumen);
        return "redirect:findAll.do";
    }

}
