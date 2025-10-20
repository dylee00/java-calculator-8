package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        //문자열 입력
        String input = Console.readLine();

        //기본 구분자, 커스텀 구분자를 기준으로 숫자 파싱
        String defaultDelimiter = "[,:]";

        if(input.startsWith("//")) {
            //커스텀 구분자의 길이 구하기
            int customDelimiterEndIndex = input.indexOf("\\n");
            //커스텀 구분자를 String 안에서 추출한 다음 defaultDelimiter에 추가
            String customDelimiter = input.substring(2, customDelimiterEndIndex);
            defaultDelimiter = "[" + customDelimiter + "]";
            //커스텀 구분자를 입력한 문자열을 떼고 input 값 갱신
            input = input.substring(customDelimiterEndIndex + 2);

        }
        String[] numbers = input.split(defaultDelimiter);

        for (String number : numbers) {
            System.out.println(Integer.parseInt(number));
        }

    }
}
