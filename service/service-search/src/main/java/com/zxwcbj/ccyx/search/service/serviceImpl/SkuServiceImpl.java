package com.zxwcbj.ccyx.search.service.serviceImpl;


import com.zxwcbj.ccyx.client.product.ProductFeignClient;
import com.zxwcbj.ccyx.enums.SkuType;
import com.zxwcbj.ccyx.model.product.Category;
import com.zxwcbj.ccyx.model.product.SkuInfo;
import com.zxwcbj.ccyx.model.search.SkuEs;
import com.zxwcbj.ccyx.search.Repository.SkuRepository;
import com.zxwcbj.ccyx.search.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
    public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuRepository skuRepository;
    @Autowired
    private ProductFeignClient productFeignClient;
     //上架
    @Override
    public void upperSku(Long skuId) {
        //1通过远程调用，根据skuid获取相关信息
        SkuInfo skuInfo = productFeignClient.getSkuInfo(skuId);
        if (skuInfo==null){
            return;
        }
        Category category = productFeignClient.getCategory(skuInfo.getCategoryId());
        if (category==null){
            return;
        }
        //2获取数据封装SkuEs对象
        //商品分类id
        SkuEs skuEs=new SkuEs();
        skuEs.setCategoryId(category.getId());
        skuEs.setCategoryName(category.getName());
//skuinfo
    skuEs.setId(skuInfo.getId());
        skuEs.setKeyword(skuInfo.getSkuName()+","+skuEs.getCategoryName());
        skuEs.setWareId(skuInfo.getWareId());
        skuEs.setIsNewPerson(skuInfo.getIsNewPerson());
        skuEs.setImgUrl(skuInfo.getImgUrl());
        skuEs.setTitle(skuInfo.getSkuName());
        if(skuInfo.getSkuType() == SkuType.COMMON.getCode()) {
            skuEs.setSkuType(0);
            skuEs.setPrice(skuInfo.getPrice().doubleValue());
            skuEs.setStock(skuInfo.getStock());
            skuEs.setSale(skuInfo.getSale());
            skuEs.setPerLimit(skuInfo.getPerLimit());
        } else {
            //TODO 待完善-秒杀商品

        }
        //3调用方法添加ES
       skuRepository.save(skuEs);

    }
 //下架
    @Override
    public void lowerSku(Long skuId) {
        skuRepository.deleteById(skuId);

    }
}
