package thinhluffy.com.service;

import thinhluffy.com.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImp implements ProductService {

    private static Map<Integer,Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1,new Product(1,"Bia Ha Noi",15000,"Chai bia ","Ha Noi"));
        productMap.put(2,new Product(2,"Bia 333",25000,"Chai bia ","Ha Nam"));
        productMap.put(3,new Product(3,"Bia Sai Gon",35000,"Chai bia ","TP HCM"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
