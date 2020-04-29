package com.hxzy.service.impl;

import com.hxzy.common.vo.ResponseMessage;
import com.hxzy.entity.GoodsInfo;
import com.hxzy.mapper.GoodsInfoMapper;
import com.hxzy.service.GoodsInfoService;
import com.hxzy.vo.TreeGoodsInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Controller
public class GoodsInfoServiceImpl implements GoodsInfoService {

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        return this.goodsInfoMapper.deleteByPrimaryKey(id)>0;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean insert(GoodsInfo record) {
        return this.goodsInfoMapper.insert(record)>0;
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public GoodsInfo selectByPrimaryKey(Integer id) {
        return this.goodsInfoMapper.selectByPrimaryKey(id);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateByPrimaryKeySelective(GoodsInfo record) {
        return this.goodsInfoMapper.updateByPrimaryKeySelective(record)>0;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateByPrimaryKey(GoodsInfo record) {
        return this.goodsInfoMapper.updateByPrimaryKey(record)>0;
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ResponseMessage search() {
        //查询数据库
        List<GoodsInfo> dbGoodsInfo=this.goodsInfoMapper.search();

        //返回的数据
        List<TreeGoodsInfoVO> allGoodsInfo=new ArrayList<TreeGoodsInfoVO>();

        //读取parentId=0
        dbGoodsInfo.stream().filter(p -> p.getType_cate_one()==0).forEach(p ->{
            //把p对象的所有属性全部copy到TreeMenuVO对象中
            TreeGoodsInfoVO root=new TreeGoodsInfoVO();

            //通过反射来copy
            BeanUtils.copyProperties(p,root);

            //查询root是否有下一级
            getChildren(dbGoodsInfo, root);

            allGoodsInfo.add(root);
        });

        return ResponseMessage.success("ok",allGoodsInfo);
    }
    private void getChildren(List<GoodsInfo> dbGoodsInfo, TreeGoodsInfoVO root) {
        List<TreeGoodsInfoVO> dbGoodsInfoList=new ArrayList<TreeGoodsInfoVO>();
        dbGoodsInfo.stream().filter(c -> c.getType_cate_one()==root.getId()).forEach(z ->{

            TreeGoodsInfoVO child=new TreeGoodsInfoVO();

            //通过反射来copy
            BeanUtils.copyProperties(z,child);

            //查询root是否有下一级
            getChildren(dbGoodsInfo, child);

            //把这个追加到
            dbGoodsInfoList.add(child);
        });
        if (dbGoodsInfoList.size()>0){
            root.setChildren(dbGoodsInfoList);
        }
    }
}