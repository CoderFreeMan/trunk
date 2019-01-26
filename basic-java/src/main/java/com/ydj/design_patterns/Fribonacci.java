package com.ydj.design_patterns;

/**
 *  
 *  <p> Date             : 2018/11/7 </p >
 *  <p> Module             : </p >
 *  <p> Description             : </p >
 *  <p> Remark             : </p >
 * <p>
 *  @author yangdejun
 *  @version 1.0
 *  <p>--------------------------------------------------------------</p >
 *  <p>修改历史</p >
 *  <p>    序号    日期    修改人    修改原因    </p >
 *  <p>    1                           </p >
 *  
 */
public class Fribonacci {
    public static void main(String[] args) {
        System.out.println(Fribonacci(9));

    }

    public static int Fribonacci(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return Fribonacci(n - 1) + Fribonacci(n - 2);
        }
    }
}
