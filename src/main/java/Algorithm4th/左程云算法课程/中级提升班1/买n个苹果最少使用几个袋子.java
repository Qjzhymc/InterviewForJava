package Algorithm4th.左程云算法课程.中级提升班1;

public class 买n个苹果最少使用几个袋子 {
    /**
     * 店家使用捆绑销售，只提供6个每袋和8个每袋的包装袋，小虎只想购买n个苹果，
     * 想使用尽量少的袋子方便携带，如果不能购买恰好n个苹果，则不购买，返回最少使用多少个袋子。
     * 方法1：1.首先奇数直接不能购买；2.对于偶数，尽量使用8的袋子，使用N/8个8号袋子，如果剩下的能用6号袋子，就可以；
     * 如果不可以，则使用N/8-1个8号袋子，试一试剩下能不能用6号袋子，一个个试...
     * 方法2：上面方法中可以不用从N/8开始一个个试，只要剩下的苹果数大于24，就不用试了，肯定不行被6整除
     */
    public static int minBags(int apple) {
        if (apple < 0) {
            return -1;
        }
        int bag6 = -1;
        int bag8 = apple / 8;
        int rest = apple - 8*(bag8);
        while (bag8 >= 0 && rest < 24) {
            int restUse6 = minBagBase6(rest);
            if (restUse6 != -1) {
                bag6 = restUse6;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }
    private static int minBagBase6(int rest) {
        return rest % 6 == 0 ? (rest / 6) : -1;
    }

    /**
     * 方法3：直接查找规律
     * @param apple
     */
    public static int minBagAwesome(int apple) {
        if ((apple & 1) != 0) {
            return -1;
        }
        if (apple < 18) {
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1 : (apple == 12 || apple ==14 || apple == 16) ? 2 : -1;
        }
        return (apple - 18) / 8 + 3;
    }

    public static void main(String[] args) {
        int ans = minBags(100);
        System.out.println(ans);
    }
}
