package feng.ssm.controller;

import com.github.pagehelper.PageInfo;
import feng.ssm.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import feng.ssm.domain.Category;
import feng.ssm.service.ICategoryService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "7") Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Category> list = categoryService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("category-list");
        return mv;
    }

    @RequestMapping("/findBycatName")
    public ModelAndView findByName(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "7") Integer size, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView();
        String name = request.getParameter("name");
        List<Category> list = categoryService.findByName(page,size,name);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("category-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Category category) throws Exception {
        categoryService.save(category);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findCategoryToProductAdd.do")
    public ModelAndView findCategoryToProductsAdd() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Category> list = categoryService.findCategory();
        mv.addObject("categoryList",list);
        mv.setViewName("products-add");
        return mv;
    }

    @RequestMapping("/deleteCategory.do")
    public String deleteCategory(@RequestParam(name = "id",required = true) Integer id) throws Exception{
        categoryService.delete(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/updateCategory.do")
    public ModelAndView updateCategory(@RequestParam(name = "id",required = true) Integer id) throws Exception{
        ModelAndView mv = new ModelAndView();
        Category category = categoryService.findById(id);
        mv.addObject("category",category);
        mv.setViewName("category-add");
        return mv;
    }

    @RequestMapping("/update.do")
    public String update(Category category) throws Exception {
        categoryService.update(category);
        return "redirect:findAll.do";
    }

}
