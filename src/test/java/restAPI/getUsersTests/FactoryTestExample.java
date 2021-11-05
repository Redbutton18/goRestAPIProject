package restAPI.getUsersTests;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryTestExample {
    private int param;
    public FactoryTestExample(int param){
        this.param = param;
    }

    public FactoryTestExample() {
    }

    @Test
    public void testMethodOne() {
        int sumValue = param + 1;
        System.out.println("TM one output" + sumValue);
    }

    @Test
    public void testMethodTwo() {
        int sumValue = param + 2;
        System.out.println("TM two output" + sumValue);
    }

    public class SimpleTestFactory{
        @Factory
        public Object[] factoryMethod() {
            return new Object[] {
                    new FactoryTestExample(1861)
            };
        }
    }
}
