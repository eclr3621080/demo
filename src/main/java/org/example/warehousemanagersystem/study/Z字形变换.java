package org.example.warehousemanagersystem.study;

import org.springframework.util.StringUtils;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-16
 * @Description:
 * @Version: 1.0
 */


public class Z字形变换 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;


        String[][] strArr = new String[s.length()][numRows];
        int y = 0;
        for (int j = 0; j < s.length(); j++) {


            for (int k = 0; k < numRows; k++) {
                if (y >= strArr.length) {
                    break;
                }
                if (j % (numRows - 1) == 0) {
                    strArr[j][k] = String.valueOf(s.charAt(y));
                    y++;
                } else if (j % (numRows - 1) == k) {
                    int a = numRows - k - 1;
                    strArr[j][a] = String.valueOf(s.charAt(y));
                    y++;
                }

            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {

            for (int j = 0; j < strArr.length; j++) {
                if (strArr[j][i] != null) {
                    result.append(strArr[j][i]);
                }
            }

        }
        System.out.println(result.toString());
    }

//    public String convert(String s, int numRows) {
//
//        String[][] strArr = new String[s.length()][numRows];
//        int y = 0;
//        for (int j = 0; j < s.length(); j++) {
//
//            for (int k = 0; k < numRows; k++) {
//                if (y >= strArr.length) {
//                    break;
//                }
//                if (j % (numRows - 1) == 0) {
//                    strArr[j][k] = String.valueOf(s.charAt(y));
//                    y++;
//                } else if (j % (numRows - 1) == k) {
//                    int a = numRows - k - 1;
//                    strArr[j][a] = String.valueOf(s.charAt(y));
//                    y++;
//                }
//
//            }
//        }
//
//        for (int i = 0; i < numRows; i++) {
//            StringBuilder result = new StringBuilder();
//            for (int j = 0; j < strArr.length; j++) {
//                if (strArr[j][i] != null) {
//                    result.append(strArr[j][i]);
//                } else {
//                    result.append(" ");
//                }
//
//            }
//            System.out.println(result.toString());
//        }
//    }
}
