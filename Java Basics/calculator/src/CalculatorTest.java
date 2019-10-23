import org.junit.Assert;

public class CalculatorTest {
    @org.junit.Test
    public void CalculatorTest1() throws Exception{
        Assert.assertEquals(Calculator.calculate("1*2"), 2);
    }
    @org.junit.Test
    public void CalculatorTest2() throws Exception{
        Assert.assertEquals(Calculator.calculate("1+2*10"), 21);
    }
}
