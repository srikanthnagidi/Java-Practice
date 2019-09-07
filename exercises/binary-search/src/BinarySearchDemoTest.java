import org.junit.Assert;

public class BinarySearchDemoTest {
    @org.junit.Test
    public void findTargetTest1() throws Exception{
        int [] arr = new int [] {1, 5,7, 9, 10, 11, 13, 24};
        int target = 11;
        int expect = 5;
        Assert.assertEquals(expect, BinarySearchDemo.findTarget(arr, target));
    }
    @org.junit.Test
    public void findTargetTest2() throws Exception{
        int [] arr = new int [] {1, 2, 4, 5, 6};
        int target =10;
        int expect = -1;
        Assert.assertEquals(expect, BinarySearchDemo.findTarget(arr,target));
    }

    @org.junit.Test
    public void findTargetTest3() throws Exception{
        int [] arr = new int [] {1, 2,3,5};
        int target = 1;
        int expect = 0;
        Assert.assertEquals(expect, BinarySearchDemo.findTarget(arr, target));
    }
}
