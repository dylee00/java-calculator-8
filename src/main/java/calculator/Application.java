package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        //문자열 입력
        String input = Console.readLine();

        //구분자를 기준으로 숫자 파싱
        String[] numbers = input.split("[,:]");

        for (String number : numbers) {
            System.out.println(Integer.parseInt(number));
        }

    }
}
