package classtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class StringClassTest {
    @Test
    @DisplayName("split으로 잘 분리되는지 확인하는 학습 테스트")
    public void split분리테스트() {
        String str = "1,2";
        String[] s = str.split(",");

        assertThat(s).contains("1","2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
    public void split분리테스트2() {
        String str = "1";
        String[] s = str.split(",");

        assertThat(s).contains("1");
    }

    @Test
    @DisplayName("substring을 활용해 ()를 제거하고 반환하는 테스트")
    public void subString테스트() {
        String str = "(1,2)";
        String str2 = str.substring(1,4);

        assertThat(str2).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 테스트")
    public void charAt테스트() {
        String str = "abc";
        char c = str.charAt(0);

        assertThat(c).isEqualTo('a');
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 테스트")
    public void charAt테스트2() {
        String str = "abc";
        int index = 3;

        assertThatThrownBy(() -> {
            str.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + index);
    }
}