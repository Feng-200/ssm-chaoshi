package feng.ssm.controller;

import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import feng.ssm.domain.Category;
import feng.ssm.domain.Products;
import feng.ssm.service.ICategoryService;
import feng.ssm.service.IProductsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private IProductsService productsService;
    @Autowired
    private ICategoryService categoryService;

    /**
     * 查询所有商品信息
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "7") Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Products> list = productsService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("products-list");
        return mv;
    }

    @RequestMapping("/findByName")
    public ModelAndView findByName(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "7") Integer size,HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView();
        String name = request.getParameter("name");
        List<Products> list = productsService.findByName(page,size,name);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("products-list");
        return mv;
    }

    @RequestMapping("/deleteProduct.do")
    public String deleteProduct(@RequestParam(name = "id",required = true) String productId) throws Exception{
        productsService.delete(productId);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deleteSelectedProduct.do")
    public String deleteSelectedProduct(HttpServletRequest request) throws Exception{
        //1.获取所有id
        String[] ids=request.getParameterValues("uid");
        //2.调用service删除
        productsService.delSelectedProduct(ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/save.do")
    public String save(Products products, HttpServletRequest request) throws Exception {
        Category category = new Category();
        products.setCategory(category);
        productsService.save(products);
        return "redirect:findAll.do";
    }

    @RequestMapping("/updateProduct.do")
    public ModelAndView updateProduct(@RequestParam(name = "id",required = true) Integer productId) throws Exception{
        ModelAndView mv = new ModelAndView();
        Products products = productsService.findById(productId);
        List<Category> categoryListList = categoryService.findCategory();
        mv.addObject("productList",products);
        mv.addObject("categoryList",categoryListList);
        mv.setViewName("products-add");
        return mv;
    }
    @RequestMapping("/update.do")
    public String update(Products products) throws Exception {
        productsService.update(products);
        return "redirect:findAll.do";
    }

}
