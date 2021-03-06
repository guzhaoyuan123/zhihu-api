package com.hooli.zhihu.api.mapper;

import com.hooli.zhihu.api.entity.Section;
import com.hooli.zhihu.api.entity.Special;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @PackgeName: com.hooli.zhihu.api.mapper
 * @ClassName: SpecialMapper
 * @Author: redhood
 * Date: 2020/1/15 22:39
 * project name: zhihu-api
 * @Version:
 * @Description:
 */
public interface SpecialMapper {
    /**
     * 查询最新专题
     * @return
     */
    @Select("SELECT * FROM t_special ORDER BY updated DESC LIMIT 0,4")
    List<Special> selectRecent();



    /**
     * 查询所有专题
     */
    @Select("SELECT * FROM t_special")
    @Results({
            @Result(id = true,property = "specialId",column = "special_id",javaType=String.class),
            @Result(property = "title",column = "title",javaType=String.class),
            @Result(property = "introduction",column = "introduction",javaType=String.class),
            @Result(property = "banner",column = "banner",javaType=String.class),
            @Result(property = "viewCount",column = "view_count",javaType= Integer.class),
            @Result(property = "followersCount",column = "followers_count",javaType=Integer.class),
            @Result(property = "updated",column = "updated",javaType= Date.class),
            @Result(property = "sections",column = "special_id",
            many = @Many(select = "com.hooli.zhihu.api.mapper.SectionMapper.getSectionBySepcialId"))

    })
    List<Map> selectAll();

}
