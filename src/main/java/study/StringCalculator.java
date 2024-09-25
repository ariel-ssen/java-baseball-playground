package study;

import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringCalculator calculator = new StringCalculator();

        System.out.println("Enter a calculation (e.g., 2+3*4/2): ");
        String input = scanner.nextLine(); // 사용자로부터 입력 받기

        try {
            int result = calculator.calculate(input); // 계산 수행
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close(); // Scanner 자원 해제
    }

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        // 숫자와 연산자를 분리하는 정규식 (숫자 또는 연산자에 대해 분리)
        String[] tokens = input.split("(?<=[-+*/])|(?=[-+*/])");

        int result = Integer.parseInt(tokens[0]); // 첫 번째 숫자

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i]; // 연산자
            int nextNumber = Integer.parseInt(tokens[i + 1]); // 다음 숫자

            result = applyOperator(result, operator, nextNumber); // 연산 수행
        }

        return result;
    }

    private int applyOperator(int left, String operator, int right) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                if (right == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return left / right;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
/**
 *  정규식을 사용하여 연산자 앞뒤로 문자열을 분리합니다.
 *
 */

/**
 * 입력 처리: Scanner 객체를 사용해 사용자가 입력한 문자열을 받아 처리합니다. scanner.nextLine()은 문자열 전체를 한 줄로 입력받습니다.
 * 문자열 계산: 공백을 기준으로 연산자와 숫자를 분리한 후, 사칙연산을 순차적으로 처리합니다.
 * 예외 처리: 입력이 잘못되었을 경우 발생할 수 있는 예외 (예: 빈 입력, 나누기 0) 등을 처리하기 위해 try-catch 블록을 사용했습니다.
 * applyOperator 메소드: 주어진 연산자에 따라 해당 연산을 수행하는 메소드입니다. 유효하지 않은 연산자가 들어올 경우 IllegalArgumentException을 발생시킵니다.
 */