import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {
	private TestDemo testDemo = new TestDemo(); 

	@BeforeEach
	void setUp() throws Exception {
		@SuppressWarnings("unused")
		TestDemo testDemo = new TestDemo(); 
	 
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive") 
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected); 
		}else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class); 
		}
		
	}
	
	
	@Test
	private void assertThatNumberSquaredIsCorrect(){
		TestDemo mockDemo = spy(testDemo); 
		doReturn(5).when(mockDemo).getRandomInt(); 
		int fiveSquared = mockDemo.randomNumbersSquared(); 
		assertThat(fiveSquared).isEqualTo(25); 
	}
	
	
	

	
	 static  Stream<Arguments> argumentsForAddPositive() {
		arguments(2, 4, 6, false); //////////////////////////////////Is this where this goes??????????
		arguments(8, 2, 10, false); 
		arguments(0, -3, -3, true); 
		return Stream.of(); 
	}
	
	
}
