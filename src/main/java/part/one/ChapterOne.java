package part.one;

/**
 * Class contains solved tasks from firts chapter of first part of a book
 */
public class ChapterOne {
    /**
     * @param num range
     * @return last fibonacci number of @param range
     */
    public static int task12(int num) {
        if(num==0) {
            System.out.println(0);
            return 0;
        }
        if(num==1) {
            System.out.println(0+" "+1);
            return 1;
        }

        int resultSum=1;
        int previousSum=0;
        int previousResult;

        System.out.print(0+" "+1);

        for(int i=2;i<num;i++) {
            previousResult=resultSum;
            resultSum=previousSum+resultSum;
            previousSum=previousResult;
            System.out.print(" "+resultSum);
        }

        return resultSum;
    }
}
