package com.team.springboot.mapper;

import com.team.springboot.pojo.Product;
import com.team.springboot.pojo.ProductCategory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductCategoryMapper {
    @Select("Select c_Id from Controller where c_Name=#{0}")
    String selectCidBycName(String c_Name);
    @Insert("insert into product(p_Account,p_Name,c_Id,p_Title,p_Des,p_Price,p_Date) values(#{p_Account}, #{p_Name}, #{c_Id}, #{p_Title}, #{p_Des},#{p_Price},#{p_Date})")
    void insertProductCategory(ProductCategory productCategory);
    @Select("select p_Id,p_Account,p_Name,c_Name,p_Title,p_Price from product inner join Category on product.c_Id=Category.c_Id limit #{0}, #{1}")
    List<ProductCategory> selectProductCategorys(int page, int limit);
    @Select("select p_Id,p_Account,p_Name,c_Name,p_Title,p_Price from product inner join Category on product.c_Id=Category.c_Id where p_Account = #{0} limit #{1}, #{2}")
    List<ProductCategory> selectProductCategorysByaccount(String p_Account,int page, int limit);

}
