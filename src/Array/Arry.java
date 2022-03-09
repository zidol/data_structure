package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class Arry {
    public static void main(String[] args) {
        // new 키워드를 사용해서, 배열을 미리 선언하고, 데이터를 넣을 수도 있음
        Integer[] data_list = new Integer[10];
        data_list[0] = 1;
        System.out.println(data_list[2]);

        // 직접 배열 데이터 선언시 넣을 수도 있음
        Integer data_list1[] = {5, 4, 3, 2, 1};
        Integer[] data_list2 = {1, 2, 3, 4, 5};

        System.out.println(data_list2[0]);

        // 배열의 내용을 출력하려면, Arrays.toString(배열변수) 메서드를 사용하면 됨
        System.out.println("Array : " + Arrays.toString(data_list2) );

        // JAVA 에서는 기본적으로 java.util 패키지에 가변 크기의 배열을 다룰 수 있는 ArrayList 클래스도 제공하고 있음
        ArrayList<Integer> list1 = new ArrayList<Integer>(); // int 형 데이터를 담을 수 있는 가변 길이의 배열 선언
        list1.add(1); // 배열에 아이템 추가 시 add(아이템) 메서드 사용
        list1.add(2);
        list1.add(3);
        list1.add(4);
        System.out.println("ArrayList(0) : " + list1.get(0));
        System.out.println("ArrayList : " + list1);

        list1.set(0, 5); // 특정 인덱스에 해당하는 아이템 변경 시, set(인덱스번호, 변경할값) 메서드 사용
        System.out.println("0번 인데스에 추가한 값 : " + list1.get(0));

        // 배열 길이 확인하기
        System.out.println("list1 사이즈 : " + list1.size());

        //2차배열
        Integer datalist2[][] = { {1, 2, 3}, {4, 5, 6} };

        // 데이터 2 인덱스로 지정해서 출력해보기
        System.out.println(datalist2[0][1]);

        // 데이터 5 인덱스로 지정해서 출력해보기
        System.out.println(datalist2[1][1]);

        //3차배열
        Integer[][][] datalist3 = {
                {
                        {1, 2, 3},
                        {4, 5, 6}
                },
                {
                        {7, 8, 9},
                        {10, 11, 12}
                }
        };

        // 데이터 5 인덱스로 지정해서 출력해보기
        System.out.println( datalist3[0][1][1] );

        // 데이터 12 인덱스로 지정해서 출력해보기
        System.out.println( datalist3[1][1][2] );

    }
}
