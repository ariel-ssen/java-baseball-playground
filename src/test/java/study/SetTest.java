package study;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    private Set<Integer> numbers;

    /**
     * setUp 메서드: 테스트가 시작되기 전에 실행되며, numbers라는 Set에 1, 2, 3을 추가합니다. 여기서 1은 중복되므로 Set에는 1, 2, 3이라는 고유한 값만 저장됩니다.
     *
     * checkSetSize 메서드: size() 메서드를 통해 Set의 크기를 확인합니다. 중복된 값을 제거한 후 Set의 크기가 3이 되는지 검증합니다. System.out.println("Set의 크기: " + size);는 크기를 콘솔에 출력합니다.
     */
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);  // 중복 값
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 테스트")
    void checkSetSize() {
        // when
        int size = numbers.size();

        // then
        System.out.println("Set의 크기: " + size);
        assertThat(size).isEqualTo(3); // 중복 값 1이 하나로 처리됨
    }

    /**
     * 2번째
     * setUp 메서드: Set에 1, 2, 3 값을 추가하는 것은 이전과 동일합니다. 중복된 값 1은 Set에 한 번만 저장됩니다.
     *
     * @ParameterizedTest: @ParameterizedTest와 @ValueSource(ints = {1, 2, 3})를 사용하여 1, 2, 3 각각에 대해 contains() 메서드를 테스트합니다. 이 방식은 반복적인 assertThat(numbers.contains()) 구문을 줄여줍니다.
     *
     * contains 메서드: input으로 1, 2, 3이 차례로 전달되며, numbers.contains(input)이 true인지 확인합니다. System.out.println을 사용해 현재 테스트 중인 값을 콘솔에 출력할 수도 있습니다.
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set에 1, 2, 3 값이 존재하는지 확인하는 테스트")
    void contains(int input) {
        // then
        System.out.println("Set에 값 " + input + "이(가) 포함되어 있는지 확인");
        assertThat(numbers.contains(input)).isTrue();
    }

    /**
     * 3번째
     * setUp 메서드: Set에 1, 2, 3 값을 추가하는 것은 동일합니다. 중복된 값 1은 한 번만 저장됩니다.
     *
     * @CsvSource: @CsvSource는 다양한 입력 값과 기대 결과를 제공하는 데 사용됩니다. 각 입력 값에 대해 contains() 메서드의 결과가 true인지 false인지 확인할 수 있도록 입력 값: 기대 결과 형식으로 데이터를 전달합니다.
     *
     * 예: 1:true, 2:true, 3:true, 4:false, 5:false
     * containsWithVariousValues 메서드: CsvSource로 전달된 각 값을 받아 contains() 메서드가 올바르게 동작하는지 확인합니다. input 값이 1, 2, 3인 경우 true를 반환하고, 4, 5인 경우 false를 반환해야 합니다.
     *
     * System.out.println: 테스트가 진행될 때 입력 값, 기대 결과, 그리고 실제 결과를 콘솔에 출력
     *
     */
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set에 포함된 값과 포함되지 않은 값에 대한 contains 메소드 테스트")
    void containsWithVariousValues(int input, boolean expected) {
        // when
        boolean result = numbers.contains(input);

        // then
        System.out.println("입력 값: " + input + " / 기대 결과: " + expected + " / 실제 결과: " + result);
        assertThat(result).isEqualTo(expected);
    }
}


/**
 * assertThat(numbers.size()).isEqualTo(3); → Set의 크기를 검증
 * assertThat(numbers.contains(input)).isTrue(); → Set에 특정 값이 포함되어 있는지 검증
 * assertThat(result).isEqualTo(expected); → 특정 입력 값이 Set에 포함되어 있을지 없을지에 대한 기대 결과를 검증
 */

/**
 * Set 크기 검증:
 * assertThat(size).isEqualTo(3);
 */

/**
 * Set의 특정 값 존재 여부 검증:
 * assertThat(numbers.contains(input)).isTrue();
 */

/**
 * 다양한 값에 대한 검증:
 * assertThat(result).isEqualTo(expected);
 */

/**
 * 추가적인 AssertJ 메서드
 * 만약 테스트를 좀 더 유연하게 검증하고 싶다면 AssertJ의 다른 메서드들을 활용할 수 있습니다. 예를 들어:
 *
 * assertThat(numbers).containsExactlyInAnyOrder(1, 2, 3);
 * Set에 1, 2, 3이 정확히 포함되어 있는지, 순서에 상관없이 검증할 수 있습니다.
 *
 * assertThat(numbers).doesNotContain(4, 5);
 * Set에 4와 5가 포함되지 않았는지를 검증할 수 있습니다.
 */
