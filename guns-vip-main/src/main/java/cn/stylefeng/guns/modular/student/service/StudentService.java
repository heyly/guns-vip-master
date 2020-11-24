package cn.stylefeng.guns.modular.student.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.student.entity.Student;
import cn.stylefeng.guns.modular.student.model.params.StudentParam;
import cn.stylefeng.guns.modular.student.model.result.StudentResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhang
 * @since 2020-10-29
 */
public interface StudentService extends IService<Student> {

    /**
     * 新增
     *
     * @author zhang
     * @Date 2020-10-29
     */
    void add(StudentParam param);

    /**
     * 删除
     *
     * @author zhang
     * @Date 2020-10-29
     */
    void delete(StudentParam param);

    /**
     * 更新
     *
     * @author zhang
     * @Date 2020-10-29
     */
    void update(StudentParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhang
     * @Date 2020-10-29
     */
    StudentResult findBySpec(StudentParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhang
     * @Date 2020-10-29
     */
    List<StudentResult> findListBySpec(StudentParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhang
     * @Date 2020-10-29
     */
     LayuiPageInfo findPageBySpec(StudentParam param);

}
