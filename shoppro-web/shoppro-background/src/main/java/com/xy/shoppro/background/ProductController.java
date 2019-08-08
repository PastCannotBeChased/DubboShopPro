package com.xy.shoppro.background;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.xy.shoppro.entity.TProduct;
import com.xy.shoppro.common.pojo.ResultBean;
import com.xy.shoppro.service.IProductService;
import com.xy.shoppro.vo.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author SYQ
 * Created on 2019\8\3 0003 11:43
 * Copyright 2019 Ultrapower,Inc. All rights revserved.
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Reference
    private IProductService productService;

    @RequestMapping("hello")
    public String hello(){
        return "index";
    }

    @RequestMapping("hello1")
    public String hell1o(){
        return "test";
    }

    @RequestMapping("getOneTest/{id}")
    @ResponseBody
    public TProduct getProductById(@PathVariable Long id){

        return productService.selectByPrimaryKey(id);
    }

    @RequestMapping("helloHtml")
    public String helloHtml(){
        return "product/hello";
    }

    /**
     * 分页查询商品
     * @param pageInfos
     * @param model
     * @return
     */
    @RequestMapping("page")
    public String page(PageInfo pageInfos, Model model){
        if(pageInfos.getPageNum()==0){
            pageInfos.setPageNum(1);
        }
        if(pageInfos.getPageSize()==0){
            pageInfos.setPageSize(5);
        }
        PageInfo<TProduct> pageInfo=productService.page(pageInfos.getPageNum(),pageInfos.getPageSize());
        model.addAttribute("pageInfo",pageInfo);
        return "product/list";
    }

    /**
     * 进到添加页面
     * @return
     */
    @RequestMapping("toAdd")
    public String toAdd(){
        return "product/add";
    }

    /**
     * 添加产品
     * @param product
     * @param response
     * @throws IOException
     */
    @RequestMapping("addProduct")
    public void addProduct(ProductVO product, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf8");
        Long result=productService.add(product);
        if(result>0){
            response.getWriter().write("<script>alert('添加成功');location.href='../product/page';</script>");
        }else{
            response.getWriter().write("<script>alert('添加失败');location.href='../product/page';</script>");
        }
    }

    /**
     * 商品回显
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("toModify")
    public String toModify(Long id, ModelMap map){
        ProductVO product=productService.toModify(id);
        map.put("product",product);
        return "product/modify";
    }

    /**
     * 修改商品
     * @param product
     * @param response
     * @throws IOException
     */
    @RequestMapping("modifyProduct")
    public void modifyProduct(ProductVO product,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf8");
        int result=productService.updateProduct(product);
        if(result>0){
            response.getWriter().write("<script>alert('修改成功');location.href='../product/page';</script>");
        }else{
            response.getWriter().write("<script>alert('修改失败');location.href='../product/page';</script>");
        }
    }

    /**
     * 单体删除
     * @param id
     * @return ResultBean
     */
    @RequestMapping("del")
    @ResponseBody
    public ResultBean delByid(Long id){
        int result = productService.delProductById(id);
        if(result>0){
            return new ResultBean<String>(200,"删除成功！");
        }
        return new ResultBean<String>(500,"您的操作有误，请稍后再试！");
    }

    /**
     * 商品的批量删除
     * @param ids
     * @return
     */
    @RequestMapping("dels")
    @ResponseBody
    public ResultBean delByIds(@RequestParam("ids") List<Long> ids){
        int result= productService.delProductsByIds(ids);
        if(result>0){
            return new ResultBean<String>(200,"删除成功！");
        }
        return new ResultBean<String>(500,"您的操作有误，请稍后再试！");
    }
}
