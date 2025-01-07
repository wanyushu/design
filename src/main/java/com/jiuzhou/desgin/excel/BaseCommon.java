package com.jiuzhou.desgin.excel;

import com.jiuzhou.desgin.excel.annotation.CheckData;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;

/**
 * github地址 http://www.github.com/wanyushu
 * gitee地址 http://www.gitee.com/wanyushu
 *
 * @author yushu
 * @email 921784721@qq.com
 * @date 2025/1/7 15:09
 */
public class BaseCommon<T> {

    protected static final String NO_EMPTY= "不能为空,";

    public String checkData(T t){
        String info = null;
        StringBuilder sb = new StringBuilder();
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(CheckData.class)) {
                CheckData apiModelProperty = field.getAnnotation(CheckData.class);
                if (apiModelProperty.required()) { // 判断是否必填
                    field.setAccessible(true); // 允许访问私有属性
                    try {
                        Object value = field.get(t);
                        if (value == null) {
                            // 使用 value 属性描述字段名称，添加错误信息到 importResDTO
                            sb.append(apiModelProperty.value());
                            sb.append(NO_EMPTY);
                            info=sb.toString();
                            //值是否符合字典要求
                        }else if(StringUtils.isNotBlank(apiModelProperty.dictName())){

                            sb = this.searchDictList(sb,apiModelProperty.dictName(),value,apiModelProperty.value(),field,t);
                            info = sb.toString();
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace(); // 处理异常
                    }
                }else if(StringUtils.isNotBlank(apiModelProperty.dictName())){//如果非必填，但是填了
                    field.setAccessible(true);
                    try {
                        Object value = field.get(t);
                        if(value!=null){
                            sb = this.searchDictList(sb,apiModelProperty.dictName(),value,apiModelProperty.value(),field,t);
                            info = sb.toString();
                        }
                    }catch (Exception e){
                        e.printStackTrace(); // 处理异常
                    }

                }
            }
        }
        return info;
    }


    //检查某字典类型的名称是否符合预期要求
    private StringBuilder searchDictList(StringBuilder sb, String dictType, Object value, String apiValue, Field field, Object targetObject) {

//        List<SysDictDTO> sysDictDTOS = AeyeCacheManager.getList(CachePrexConstants.common_dict_list,
//                AeyeReflectionUtil.getFieldName(SysDictDTO::getDicType) + AbstractCacheBOImpl.MERGE_KEY_SPLIT_MARK + dictType,
//                SysDictDTO.class);
//        // 判断 value 是否包含在范围内
//        boolean isValid = false;
//        String dicValue = null; // 用于存储字典值
//        for (SysDictDTO sysDictDTO : sysDictDTOS) {
//            if (sysDictDTO.getDicName().equals(value)) {
//                // 字典名称如果符合预期，将该字段 field 值设置为 sysDictDTO.getDicValue;
//                isValid = true;
//                dicValue = sysDictDTO.getDicValue(); // 获取对应的字典值
//                break;
//            }
//        }
//        if (isValid) {
//            // 设置字段的值为字典值
//            try {
//                field.setAccessible(true); // 允许访问私有属性
//                field.set(targetObject, dicValue); // 设置字段值为字典值
//            } catch (IllegalAccessException e) {
//                e.printStackTrace(); // 处理异常
//            }
//        } else {
//            // 添加错误信息到 importResDTO
//            sb.append(apiValue);
//            sb.append("如");
//            // 列举符合要求的值
//            Set<String> collect = sysDictDTOS.stream().map(SysDictDTO::getDicName).collect(Collectors.toSet());
//            sb.append(collect);
//        }
        return sb;
    }

    public boolean checkLastLine(T t){
        for (Field field : t.getClass().getDeclaredFields()) {
            // 检查是否有 @ApiModelProperty 注解
            if (field.isAnnotationPresent(CheckData.class)) {
                CheckData apiModelProperty = field.getAnnotation(CheckData.class);
                if (apiModelProperty.required()) { // 判断是否必填
                    field.setAccessible(true); // 允许访问私有属性
                    try {
                        Object value = field.get(t);
                        if (value != null) {
                            // 使用 value 属性描述字段名称，添加错误信息到 importResDTO
                            return false;
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace(); // 处理异常
                    }
                }
            }
        }
        return true;
    }
}
