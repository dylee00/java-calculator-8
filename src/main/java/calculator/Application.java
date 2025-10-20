package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        //문자열 입력
        String input;
        try{
           input = Console.readLine();
        }catch(Exception e){
            throw new  IllegalArgumentException("입력 오류가 발생했습니다.");
        }

        //기본 구분자, 커스텀 구분자를 기준으로 숫자 파싱
        String defaultDelimiter = "[,:]";

        if(input.startsWith("//")) {
            //커스텀 구분자의 길이 구하기
            int customDelimiterEndIndex = input.indexOf("\\n");
            //커스텀 구분자를 String 안에서 추출한 다음 defaultDelimiter에 추가
            String customDelimiter = input.substring(2, customDelimiterEndIndex);

            if(customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
            }

            defaultDelimiter = "[" + customDelimiter + "]";
            //커스텀 구분자를 입력한 문자열을 떼고 input 값 갱신
            input = input.substring(customDelimiterEndIndex + 2);

        }

        //numbers 배열에 구분자를 기준으로 파싱한 문자 저장
        String[] numbers = input.split(defaultDelimiter);

        //숫자의 합 계산
        int result = 0;
        for (String number : numbers) {
            int parsingNum = 0;
            //적절한 구분자가 입력되었는지 검증
            try{
                parsingNum = Integer.parseInt(number);

                //음수 검증
                if(parsingNum < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
            }catch(Exception e){
                throw new IllegalArgumentException("구분자에 맞지 않는 입력입니다.");
            }
            result += parsingNum;
        }

        //계산한 값 반환
        System.out.println("결과 : " + result);

    }
}
