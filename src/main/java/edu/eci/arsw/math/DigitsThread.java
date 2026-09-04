package edu.eci.arsw.math;

public class DigitsThread extend Thread {

    private int start;
    private int nums;
    private byte[] result;

    public DigitsThread(int start, int nums){
        this.start = start;
        this.nums = nums;
    }

    @Override
    public void run() {
        return digit = PiDigits.getDigits(start, nums);
    }

    public byte[] getResult() {
        return result;
    }
}