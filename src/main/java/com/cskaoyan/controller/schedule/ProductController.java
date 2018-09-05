package com.cskaoyan.controller.schedule;


import com.cskaoyan.domain.schedule.Product;
import com.cskaoyan.service.schedule.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 16:42 2018/9/1
 * @Modified By:
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;



    /**
     * @Author: QiaoYuhao
     * @Description: /find 转向product_list页面 /list 返回查询到的数据信息
     *               todo 分页 所有显示页面的分页
     * @return:  "product_list" list页面
     * @return:  productList 查询到的list信息
     */
    @RequestMapping("/find")
    public String findProduct(){
        return "product_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public HashMap getProductList(Integer page, Integer rows){
        PageHelper.startPage(page,rows);
        List<Product> productList = productService.findProduct();

        HashMap map = new HashMap();
        //pageInfo对象，并把分页参数放入map返回
        PageInfo pageInfo = new PageInfo(productList);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }


    /**
     * @Author: QiaoYuhao
     * @Description: /add_judge 添加前的判断 和 /add 添加窗口的打开 以及 /insert 添加操作
     *               todo add_judge需要做用户权限的判断
     * @param:  product 表单获取的product对象
     * @return: map 返回map对象
     */
    @RequestMapping("/add_judge")
    public String judgeBeforeAddProduct(){
        return "product_list" ;
    }

    @RequestMapping("/add")
    public String addProductAfterJudge(){
        return "product_add" ;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public HashMap insertProduct(Product product){
        boolean ret = productService.addProduct(product);
        HashMap map = new HashMap();
        if(ret){
            String status = "200";
            map.put("status",status);
        }else {
            String msg = "添加失败，请重试.";
            map.put("msg",msg);
        }
        return map;
    }


    /**
     * @Author: QiaoYuhao
     * @Description: 模糊查询 分别是单条件查询，因为代码基本一样，因此合并处理
     * @param:  searchValue 查询的参数
     * @return: productList 返回查询后的list
     */
    @RequestMapping(value = {"/search_product_by_productName","/search_product_by_productId","/search_product_by_productType"})
    @ResponseBody
    public HashMap getProductListByConditon(@RequestParam String searchValue, HttpServletRequest request, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        //获取当前请求的uri
        String requestURI = request.getRequestURI();

        HashMap map = new HashMap();

        //判断请求来自哪个uri，分支处理
        if (requestURI.contains("productName")) {
            map.put("productName", searchValue);
        } else if (requestURI.contains("productId")) {
            map.put("productId", searchValue);
        }else if(requestURI.contains("productType")){
            map.put("productType", searchValue);
        }
        HashMap retrunMap = new HashMap();
        List<Product> productList = productService.findProductByCondition(map);
        System.out.println("productList = "+productList);
        //pageInfo对象，并把分页参数放入map返回
        PageInfo pageInfo = new PageInfo(productList);
        retrunMap.put("total", pageInfo.getTotal());
        retrunMap.put("rows", pageInfo.getList());
        return retrunMap;
    }


    /**
     * @Author: QiaoYuhao
     * @Description: /edit_judge 修改前的判断   /edit 修改窗口的打开
     *               /update_all 修改全部信息操作  /update_note修改客户介绍操作
     *               todo edit_judge需要做用户权限的判断
     * @param:  product 表单获取的product对象
     * @return: map 返回map对象
     */
    @RequestMapping("/edit_judge")
    public String judgeProductBeforeEdit(){
        return "product_list" ;
    }

    @RequestMapping("/edit")
    public String editProductAfterJudge(){
        return "product_edit" ;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public HashMap updateProduct(Product product){
        boolean ret = productService.updateProduct(product);
        HashMap map = new HashMap();
        if(ret){
            String status = "200";
            map.put("status",status);
        }else {
            String msg = "修改产品信息失败，请重试";
            map.put("msg",msg);
        }
        return map;
    }

    @RequestMapping("/update_note")
    @ResponseBody
    public HashMap updateProductNote(String productId,String note){
        Product product = new Product();
        product.setProductId(productId);
        product.setNote(note);
        boolean ret = productService.updateProductSelective(product);
        HashMap map = new HashMap();
        if(ret){
            String status = "200";
            map.put("status",status);
        }else {
            String msg = "修改产品介绍失败，请重试";
            map.put("msg",msg);
        }
        return map;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: /delete_judge 修改前的判断 /delete_batch批量删除产品操作
     *               todo delete_judge需要做用户权限的判断
     * @param:  product 表单获取的product对象
     * @return: map 返回map对象
     */

    @RequestMapping("/delete_judge")
    public String judgeProductBeforeDelete(){
        return "product_list" ;
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public HashMap deleteProducts(String[] ids){
        boolean ret = false;
        try {
            ret = productService.deleteProducts(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap<String, Object> map = new HashMap();

        if(ret){
            String status = "200";
            map.put("status",status);
        }else {
            String msg = "删除失败，请重试。";
            map.put("msg",msg);
        }
        return map;
    }

    @RequestMapping("/get/{productId}")
    @ResponseBody
    public Product getProductForOthers(@PathVariable String productId){
        //获取并返回product对象
        Product product = productService.findProductById(productId);
        return product;
    }

    //todo 这里可以只查询productName集合，提高查询数据库的效率
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Product> getProductData(){
        List<Product> product = productService.findProduct();

        return product;

    }




}
