package cn.stylefeng.guns.modular.student.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhang
 * @since 2020-10-29
 */
@Data
public class StudentParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    private String studentId;

    private String studentName;

    private Integer age;

    private String sex;

    @Override
    public String checkParam() {
        return null;
    }

}
