package com.emusicstore.controller;

import com.emusicstore.dao.ProductDAO;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Balram on 8/2/2016.
 */
//This is Admin Controller
public class AdminController {
    private Path path;

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productDAO.getAllProducts();
        model.addAttribute("products", products);

        return "productInventory";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");

        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request) {
        productDAO.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product Image Saving Failed...", e);
            }
        }

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {

        productDAO.deleteProduct(id);
        return "redirect:/admin/productInventory";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        Product product = productDAO.getProductById(id);

        model.addAttribute(product);
        return "editProduct";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
    public String editProductPost(@ModelAttribute("product") Product product, Model model, HttpServletRequest request) {

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product Image Saving Failed while editing...", e);
            }
        }

        productDAO.editProduct(product);

        return "redirect:/admin/productInventory";
    }


}
