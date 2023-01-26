package classtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    public void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size() 사용해 Set의 크기 확인하는 테스트")
    @Test
    public void 요구사항1() {
        int setSize = numbers.size();
        assertThat(setSize).isEqualTo(3);
    }

    @DisplayName("contain()을 활용해 값이 존재하는지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void 요구사항2(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("contain()을 활용해 값이 존재하는거와 존재하지 않는 값 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
    public void 요구사항3(int element, boolean expected) {
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }
}