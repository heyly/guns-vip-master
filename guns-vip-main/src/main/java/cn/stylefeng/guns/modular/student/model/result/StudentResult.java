package cn.stylefeng.guns.modular.student.model.result;

import lombok.Data;
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
public class StudentResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    private String studentId;

    private String studentName;

    private Integer age;

    private String sex;

}
