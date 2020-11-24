package cn.stylefeng.guns.modular.student.mapper;

import cn.stylefeng.guns.modular.student.entity.Student;
import cn.stylefeng.guns.modular.student.model.params.StudentParam;
import cn.stylefeng.guns.modular.student.model.result.StudentResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhang
 * @since 2020-10-29
 */
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 获取列表
     *
     * @author zhang
     * @Date 2020-10-29
     */
    List<StudentResult> customList(@Param("paramCondition") StudentParam paramCondition);

    /**
     * 获取map列表
     *
     * @author zhang
     * @Date 2020-10-29
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") StudentParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author zhang
     * @Date 2020-10-29
     */
    Page<StudentResult> customPageList(@Param("page") Page page, @Param("paramCondition") StudentParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author zhang
     * @Date 2020-10-29
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") StudentParam paramCondition);

}
