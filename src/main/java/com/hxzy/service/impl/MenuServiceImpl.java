package com.hxzy.service.impl;

import com.hxzy.common.vo.ResponseMessage;
import com.hxzy.entity.Menu;
import com.hxzy.mapper.MenuMapper;
import com.hxzy.service.MenuService;
import com.hxzy.vo.TreeMenuVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        return false;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean insert(Menu record) {
        return this.menuMapper.insert(record)>0;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Menu selectByPrimaryKey(Integer id) {
        return this.menuMapper.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateByPrimaryKeySelective(Menu record) {
        return this.menuMapper.updateByPrimaryKeySelective(record)>0;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateByPrimaryKey(Menu record) {
        return this.menuMapper.updateByPrimaryKey(record)>0;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ResponseMessage search() {
        //查询数据库，得到所有的节点
        List<Menu> dbMenus=this.menuMapper.search();
        //返回的数据
        List<TreeMenuVO> allTree=new ArrayList<TreeMenuVO>();

        //读取parentId=0
        dbMenus.stream().filter(p ->  p.getParentId()==0).forEach( p -> {
            //把p  对象里的所有属性 全部 copy  到 TreeMenuVO 对象中
            TreeMenuVO  root=new TreeMenuVO();
            //通过反射来copy
            BeanUtils.copyProperties(p, root);

            //查询root它是否有下一级
            getChildren(dbMenus, root);

            allTree.add(root);
        });

        return ResponseMessage.success("ok",allTree);
    }

    //递归读取菜单
    private void getChildren(List<Menu> dbMenus, TreeMenuVO root) {
        List<TreeMenuVO> childrenList=new ArrayList<>();
        dbMenus.stream().filter(c -> c.getParentId()== root.getId()).forEach( z->{
            TreeMenuVO  child=new TreeMenuVO();
            //通过反射来copy
            BeanUtils.copyProperties(z, child);

            //查询root它是否有下一级
            getChildren(dbMenus, child);

            //把这个追加到
            childrenList.add(child);
        });

        if(childrenList.size()>0){
            root.setChildren(childrenList);
        }
    }
}
