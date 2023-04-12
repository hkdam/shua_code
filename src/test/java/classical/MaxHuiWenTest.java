package classical;

import junit.framework.TestCase;
import org.junit.Test;

public class MaxHuiWenTest extends TestCase {

    MaxHuiWen maxHuiWen = new MaxHuiWen();

    @Test
    public void test1(){
        String test = "asdbfgfbdjoij";
        System.out.println(maxHuiWen.getMaxHuiWen(test));
    }

}