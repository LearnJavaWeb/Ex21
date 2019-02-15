package thinhluffy.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import thinhluffy.com.model.Product;
import thinhluffy.com.service.ProductService;
import thinhluffy.com.service.ProductServiceImp;

@Controller
public class ProductController {
    private ProductService productService = new ProductServiceImp();
    //Hien Thi Danh Sach San Pham
    @GetMapping("/list")
    public String index(Model model){
        model.addAttribute("productMap",productService.findAll());
        return "index";
    }
    //Them Khach Hang
    @GetMapping("/product/create")
    public String create(Model model){
        model.addAttribute("productMap",new Product());
        return "create";
    }
    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirected){
        product.setId((int)Math.random()*10000);
        productService.save(product);
        redirected.addFlashAttribute("nodify"," Add Success");
        return "redirect:/list";
    }
    //Sua Khach Hang
    @GetMapping("/editProduct/{id}/edit")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("productMap",productService.findById(id));
        return "edit";
    }
    @PostMapping("/product/update")
    public String update(Product product,RedirectAttributes redirected){
        productService.update(product.getId(),product);
        redirected.addFlashAttribute("nodify"," Edit Success");
        return "redirect:/list";
    }
    //Xoa San pham
    @GetMapping("/deleteProduct/{id}/delete")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("productMap",productService.findById(id));//Tim kiem theo ID
        return "delete";
    }
    @PostMapping("/product/deleted")
    public String deleted(Product product,RedirectAttributes redirected)
    {
        productService.remove(product.getId());
        redirected.addFlashAttribute("nodify","Delete Success");
        return "redirect:/list";
    }
    //View San Pham Pham
    @GetMapping("/viewProduct/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("productMap",productService.findById(id));
        return "view";
    }
}
