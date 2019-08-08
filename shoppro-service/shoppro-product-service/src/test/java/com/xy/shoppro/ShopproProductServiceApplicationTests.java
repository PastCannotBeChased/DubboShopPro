package com.xy.shoppro;

import com.xy.shoppro.entity.TProductType;
import com.xy.shoppro.service.IProductService;
import com.xy.shoppro.service.IProductTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopproProductServiceApplicationTests {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductTypeService productTypeService;

    @Test
    public void contextLoads() throws SQLException {
//        System.out.println(dataSource.getConnection());
        System.out.println(productService.page(1, 1).getList().size());
    }

    @Test
    public void testList(){
        for (TProductType tProductType : productTypeService.list()) {
            System.out.println(tProductType.getTypeName());
        }
    }
}
