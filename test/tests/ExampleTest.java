package tests;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
public class ExampleTest {
  @Test
  public void testAddition() {
    int a = 2;
    int b = 3;
    if (a + b != 5) {
      fail();
    }
  }
}

