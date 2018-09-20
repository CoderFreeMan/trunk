package com.ydj.design_patterns.builder;

/**
 * <p> Date             :2018/9/20 </p>
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
public class NutritionFacts {

    private final int servingSize;

    private final int servings;

    private final int calories;

    private final int fat;

    private final int sodium;

    private final int carbohydrate;

    public static class NutritionFactsBuilder {

        private final int servingSize;

        private final int servings;

        private int calories        = 0;

        private int fat             = 0;

        private int sodium          = 0;

        private int carbohydrate    = 0;

        public NutritionFactsBuilder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        public NutritionFactsBuilder calories(int val) {
            calories = val;
            return this;
        }

        public NutritionFactsBuilder fat(int val) {
            fat = val;
            return this;
        }

        public NutritionFactsBuilder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFactsBuilder sodium(int val) {
            sodium = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(NutritionFactsBuilder NutritionFactsBuilder) {
        servingSize = NutritionFactsBuilder.servingSize;
        servings    = NutritionFactsBuilder.servings;
        calories    = NutritionFactsBuilder.calories;
        fat         = NutritionFactsBuilder.fat;
        sodium      = NutritionFactsBuilder.sodium;
        carbohydrate = NutritionFactsBuilder.carbohydrate;
    }

}
