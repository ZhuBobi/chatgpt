package personal.bobi.chatgpt.util;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ArrayUtil;
import personal.bobi.chatgpt.entity.Result;

import java.util.Arrays;

public class ResultUtil {


    public static<T> Result<T> ok() {
        return ok("000000", "success", null);
    }

    public static <T> Result<T> ok(T data) {
        return ok("000000", "success", data);
    }

    public static <T> Result<T>  ok(String code, T data) {
        return ok(code, "success", data);
    }

    public static <T> Result<T>  ok(String code, String message, T data) {
        return new Result<T>(code, message, data);
    }

    public static<T> Result<T> error(final int code,final String msg) {
        return new Result<T>(String.valueOf(code), msg,null);
    }


    public static void main(String[] args){
        String result = "[\"\n\n1. 饮食调节：多吃新鲜蔬菜水果，少吃油腻食物，少喝咖啡、茶、酒等刺激性饮料；\n\n2. 锻炼身体：每天坚持锻炼，可以改善血液循环，缓解偏头痛；\n\n3. 正确的睡眠：保证充足的睡眠，每天睡眠时间不少于7小时；\n\n4. 避免精神紧张：尽量避免精神紧张，多参加一些娱乐活动，放松心情；\n\n5. 合理用药：可以根据医生的建议，合理使用药物，如非甾体类抗炎药、抗血小板药等；\n\n6. 正确的姿势：保持正确的姿势，避免长时间保持不良姿势；\n\n7. 合理的按摩：可以选择合适的按摩方法，如肩颈按摩、头部按摩等，缓解偏头痛。\"]";
        result = result.replaceAll("\\[" ,"");
        result = result.replaceAll("]" ,"");
        String[] res = result.split("\n\n");
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
