package bartek.logic;

final class ArrayHelper {
    static int[] revertValues(int[] array) {
        int[] reverted = new int[array.length];
public final class ArrayHelper {
    public static int[] revertValues(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            reverted[i] = array[array.length - i - 1];
            reverted[array.length - i - 1] = temp;
        }
        return reverted;
    }
}
