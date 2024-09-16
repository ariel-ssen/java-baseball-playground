package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /**
     * split() 함수는 Java에서 문자열을 특정 구분자를 기준으로 분리하여 배열로 반환하는 함수
     * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     *
     * assertThat은 AssertJ 라이브러리에서 제공하는 주요 메서드로, 검증 대상(테스트하려는 값)을 지정하는 데 사용
     * containsExactly는 배열이나 리스트와 같은 컬렉션의 요소들이 정확히 원하는 값과 일치하는지 검증하는 메서드
     *
     *
     * 요약:
     * assertThat: 테스트 대상(배열, 객체, 변수 등)을 지정하는 메서드.
     * containsExactly: 컬렉션(배열, 리스트 등)이 지정한 값과 순서가 정확히 일치하는지 검증하는 메서드.
     */
    @Test
    void splitByComma() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void splitByComma2() {
        String[] result1 = "1,2".split(",");
        String[] result2 = "1".split(",");

        // print 출력
        System.out.println("splitByComma() 결과 1: ");
        for (String s : result1) {
            System.out.println(s);
        }

        System.out.println("splitByComma() 결과 2: ");
        for (String s : result2) {
            System.out.println(s);
        }

        // assertThat 검증
        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).containsExactly("1");
    }
}
