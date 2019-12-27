package part.one.chapter.one;

/**
 * Class contains solved tasks from first chapter of first part of a book
 */
public class ChapterOne {
    /**
     * @param num range
     * @return last fibonacci number of param range
     * if number is more than 'int' range returns -1
     * the sense of the 12 task is to calculate all fibonacci numbers for numbers from 0 to param
     */
    public static int task12(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }

        int resultSum = 1;
        int previousSum = 0;
        int previousResult;

        for (int i = 1; i < num; i++) {
            previousResult = resultSum;
            if(previousSum + resultSum < 0) {
                return -1;
            }
            resultSum = previousSum + resultSum;
            previousSum = previousResult;
        }

        return resultSum;
    }
}
