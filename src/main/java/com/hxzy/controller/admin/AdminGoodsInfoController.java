package com.hxzy.controller.admin;

import com.hxzy.common.vo.ResponseMessage;
import com.hxzy.entity.GoodsInfo;
import com.hxzy.service.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/admin/goodsInfo")
@RestController
public class AdminGoodsInfoController {

    @Autowired
    private GoodsInfoService goodsInfoService;

    @GetMapping(value = "/data")
    public ResponseMessage ajaxData(){
        return this.goodsInfoService.search();
    }

    @PostMapping(value = "/save")
    public ResponseMessage saveData(GoodsInfo goodsInfo){
        boolean result=true;
        if(goodsInfo.getId()==null||goodsInfo.getId()==0){
            result=this.goodsInfoService.insert(goodsInfo);
        }else {
            result=this.goodsInfoService.updateByPrimaryKey(goodsInfo);
        }
        ResponseMessage rm=result? ResponseMessage.success(): ResponseMessage.failed();
        return rm;
    }
}
