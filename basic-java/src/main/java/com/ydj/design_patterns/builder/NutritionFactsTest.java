package com.ydj.design_patterns.builder;

/**
 * <p> Date             :2018/9/21 </p>
 * <p> Module           : </p>
 * <p> Description      : </p>
 * <p> Remark           : </p>
 *
 * @author yangdejun
 * @version 1.0
 * <p>--------------------------------------------------------------</p>
 * <p>修改历史</p>
 * <p>    序号    日期    修改人    修改原因    </p>
 * <p>    1                                     </p>
 */
public class NutritionFactsTest {

    public static void main(String[] args) {
        NutritionFacts a = new NutritionFacts.NutritionFactsBuilder(240, 8)
                .calories(35).sodium(35).carbohydrate(27).build();
        System.out.println(a.getClass().getName());
    }

}
