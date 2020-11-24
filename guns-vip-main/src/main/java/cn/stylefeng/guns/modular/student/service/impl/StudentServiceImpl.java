package cn.stylefeng.guns.modular.student.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.student.entity.Student;
import cn.stylefeng.guns.modular.student.mapper.StudentMapper;
import cn.stylefeng.guns.modular.student.model.params.StudentParam;
import cn.stylefeng.guns.modular.student.model.result.StudentResult;
import  cn.stylefeng.guns.modular.student.service.StudentService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhang
 * @since 2020-10-29
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Override
    public void add(StudentParam param){
        Student entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(StudentParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(StudentParam param){
        Student oldEntity = getOldEntity(param);
        Student newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public StudentResult findBySpec(StudentParam param){
        return null;
    }

    @Override
    public List<StudentResult> findListBySpec(StudentParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(StudentParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(StudentParam param){
        return param.getStudentId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Student getOldEntity(StudentParam param) {
        return this.getById(getKey(param));
    }

    private Student getEntity(StudentParam param) {
        Student entity = new Student();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
