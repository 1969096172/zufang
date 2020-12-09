package com.li.ers.servlet;

import com.li.ers.model.Account;
import com.li.ers.model.Goods;
import com.li.ers.model.Orders;
import com.li.ers.model.User;
import com.li.ers.service.HomeService;
import com.li.ers.service.LoginSevice;
import com.li.ers.service.MineService;
import com.li.ers.service.Orderservice;
import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class MineServelet extends HttpServlet {
    private MineService mineService = new MineService();
    private HomeService homeService = new HomeService();
    private Orderservice orderservice = new Orderservice();
    int userI=0;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    //method反射机制调用方法
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        String methodName = request.getParameter("method");
        try{
            //利用反射获取方法
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
            //执行相应的方法
            method.setAccessible(true);
            method.invoke(this,request,response);
        } catch (Exception e) {
            // TODO AUTO-generated catch block
            e.printStackTrace();
        }
    }


    protected void getminefix(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userid = Integer.parseInt(request.getParameter("userid"));
        User user = homeService.getmine(userid);
        HttpSession session = request.getSession();  //通过request获取session
        session.setAttribute("usermineM",user);
        request.getRequestDispatcher("/WEB-INF/pages/mine_fix.jsp").forward(request, response);
    }
    protected void getmine_fixgo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(10 * 1024 * 1024); // 单个文件大小限制
            upload.setSizeMax(50 * 1024 * 1024); // 总文件大小限制
            upload.setHeaderEncoding("UTF-8"); // 对中文文件编码处理

            if (upload.isMultipartContent(request)) {

                User user = new User();
                List<FileItem> list = upload.parseRequest(request);
                for (FileItem item : list) {

                    if (item.isFormField()) {// 普通本文内容
                        String name = item.getFieldName();
                        // 获取值
                        String value = item.getString();
                        int i = 0;
                        if (i==1){
                            userI = Integer.parseInt(value);
                        }else{
                            i++;
                        }

                        value = new String(value.getBytes("ISO-8859-1"),
                                "UTF-8");
                        BeanUtils.setProperty(user, name, value);
                    } else {// 上传内容
                        String fieldName = item.getFieldName();
                        String path = getServletContext()
                                .getRealPath("/upload");
                        File f = new File(path);
                        if (!f.exists()) {
                            f.mkdir();
                        }
                        // 全部绝对路径
                        String name = item.getName();

                        BeanUtils
                                .setProperty(user, fieldName, "upload/" + name);

                        // 拼接文件名
                        File file = new File(path, name);
                        // 上传
                        if (!file.isDirectory()) {
                            item.write(file);
                        }
                        item.delete(); // 删除组件运行时产生的临时文件
                    }
                }

                userI =  mineService.fixuser(user);

            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        getminefixss(request,response);

    }
    protected void getminefixss(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userid = userI;
        User user = homeService.getmine(userid);
        HttpSession session = request.getSession();  //通过request获取session
        session.setAttribute("usermineM",user);
        request.getRequestDispatcher("/WEB-INF/pages/mine_fix.jsp").forward(request, response);
    }

    /**
     * 绑定银行卡
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getminemoney(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userid = Integer.parseInt(request.getParameter("userid"));
        HttpSession session = request.getSession();  //通过request获取session
        session.setAttribute("userre",userid);
        request.getRequestDispatcher("/WEB-INF/pages/moneycare.jsp").forward(request, response);
    }
    protected void addmoney(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountcare = request.getParameter("accountcare");
        double accountmoney = Double.parseDouble(request.getParameter("accountmoney"));
        int accountuserid = Integer.parseInt(request.getParameter("accountuserid"));
        Account account = new Account();
        account.setAccount(accountcare);
        account.setBalance(accountmoney);
        account.setUserid(accountuserid);

        int userre = mineService.getmoney(account);
        HttpSession session = request.getSession();  //通过request获取session
        if (userre==1){
            session.setAttribute("user_re","添加成功");
        }else if (userre==0){
            session.setAttribute("user_re","添加失败");
        }
        session.setAttribute("userre",accountuserid);
        request.getRequestDispatcher("/WEB-INF/pages/moneycare.jsp").forward(request, response);
    }

    /**
     * 发布商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getminerelgoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userid = Integer.parseInt(request.getParameter("userid"));
        HttpSession session = request.getSession();  //通过request获取session
        session.setAttribute("userre",userid);
        request.getRequestDispatcher("/WEB-INF/pages/release_goods.jsp").forward(request, response);
    }
    protected void addgoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(10 * 1024 * 1024); // 单个文件大小限制
            upload.setSizeMax(50 * 1024 * 1024); // 总文件大小限制
            upload.setHeaderEncoding("UTF-8"); // 对中文文件编码处理

            if (upload.isMultipartContent(request)) {

                Goods goods = new Goods();
                List<FileItem> list = upload.parseRequest(request);
                for (FileItem item : list) {

                    if (item.isFormField()) {// 普通本文内容
                        String name = item.getFieldName();
                        // 获取值
                        String value = item.getString();
                        value = new String(value.getBytes("ISO-8859-1"),
                                "UTF-8");
                        BeanUtils.setProperty(goods, name, value);
                    } else {// 上传内容
                        String fieldName = item.getFieldName();
                        String path = getServletContext()
                                .getRealPath("/upload");
                        File f = new File(path);
                        if (!f.exists()) {
                            f.mkdir();
                        }
                        // 全部绝对路径
                        String name = item.getName();

                        BeanUtils
                                .setProperty(goods, fieldName, "upload/" + name);

                        // 拼接文件名
                        File file = new File(path, name);
//                        goods.setGoodurl("upload/" + name);

                        // 上传
                        if (!file.isDirectory()) {
                            item.write(file);
                        }
                        item.delete(); // 删除组件运行时产生的临时文件
                    }
                }

                goods.setAdminid(1);
                goods.setStatus(0);
                int goods_re = mineService.addgoods(goods);
                HttpSession session = request.getSession();  //通过request获取session
                if (goods_re==1){
                    session.setAttribute("goods_re","添加成功");
                }else if (goods_re==0){
                    session.setAttribute("goods_re","添加失败");
                }
//                session.setAttribute("goods_re",goods_re);
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/WEB-INF/pages/release_goods.jsp").forward(request, response);

    }

    /**
     * 管理商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void setminerelgoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userid = Integer.parseInt(request.getParameter("userid"));

        List<Goods> goods0 = mineService.getgoods0(userid);
        List<Goods> goods1 = mineService.getgoods1(userid);
        List<Goods> goods2 = mineService.getgoods2(userid);
        HttpSession session = request.getSession();  //通过request获取session
        session.setAttribute("userre",userid);
        session.setAttribute("goods0",goods0);
        session.setAttribute("goods1",goods1);
        session.setAttribute("goods2",goods2);
        request.getRequestDispatcher("/WEB-INF/pages/adgoods.jsp").forward(request, response);
    }
    protected void thisSGid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int userid = Integer.parseInt(request.getParameter("userid"));
        int goodsid = Integer.parseInt(request.getParameter("thisSGid"));
        double goodsmoney = Double.parseDouble(request.getParameter("thismoney"));

        mineService.changestate(goodsid);
        mineService.changemoney(userid,goodsmoney);
        setminerelgoods(request,response);
    }
    protected void refusegoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int userid = Integer.parseInt(request.getParameter("userid"));
        int goodsid = Integer.parseInt(request.getParameter("thisSGid"));
        double goodsmoney = Double.parseDouble(request.getParameter("thismoney"));

        Orders orders = orderservice.getuserid(goodsid);
        orderservice.del(orders.getOrderid());
        mineService.changestate0(goodsid);
        mineService.changemoney(orders.getUserid(),goodsmoney);
        setminerelgoods(request,response);
    }
    /**
     * 删除上架商品
     */
    protected void deletegoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int userid = Integer.parseInt(request.getParameter("userid"));
        int goodsid = Integer.parseInt(request.getParameter("deleteid"));

        mineService.deletegoods(goodsid);

        setminerelgoods(request,response);
    }
}
