package wmx.homework;

import java.util.Random;

/**
 * 2019/9/10
 * @Author 汪铭潇
 *
 */

class Kid{
    /**
     * This class is used to describe each gourd doll
     *Name,value for sorting,color
     */
    String name;
    int val;
    skinColor color;

    public enum skinColor {
        RED(1),
        ORANGE(2),
        YELLOW(3),
        GREEN(4),
        BULE(5),
        NAVY(6),
        PURPLE(7);

        private  int val ;

        skinColor(int v){
            this.val = v;
        }

        public int getValue(){
            return this.val;
        }

        @Override
        public String toString() {
            switch (this.val){
                case 1: return "红色";
                case 2: return "橙色";
                case 3: return "黄色";
                case 4: return "绿色";
                case 5: return "青色";
                case 6: return "蓝色";
                case 7: return "紫色";
                default:return "无色";
            }

        }
    }
    Kid(String n,int v ,skinColor c){
        name = n;
        val = v;
        color = c;
    }
}


public class GourdDoll {
    /**
     * This class stands for seven gourddolls
     */
    Random random = new Random();

    Kid[] kids = { new Kid("老大",1, Kid.skinColor.RED),
            new Kid("老二",2,Kid.skinColor.ORANGE),
            new Kid("老三",3,Kid.skinColor.YELLOW),
            new Kid("老四",4,Kid.skinColor.GREEN),
            new Kid("老五",5,Kid.skinColor.BULE),
            new Kid("老六",6,Kid.skinColor.NAVY),
            new Kid("老七",7,Kid.skinColor.PURPLE)};


    void outOrder(){
        /**
         * This function is used to Disrupt the original order of kids
         */
        System.out.println("\n七兄弟原始顺序");
        show(true);
        System.out.println("\n七兄弟乱序重排");
        for( int i = 0; i<kids.length;i++){
            int rand = random.nextInt(kids.length - 1);
            Kid temp = kids[rand];
            kids[rand] = kids[i];
            kids[i] = temp;
        }
        show(true);
    }

   void show(boolean key){
       /**
        * This function is used to display the order of kids
        */
        if(key) {
            for (int i = 0; i < kids.length; i++) {
                System.out.println(kids[i].name + " ");
            }
            System.out.println(" ");
        }
        else{
            for (int i = 0; i < kids.length; i++) {
                System.out.println(kids[i].name + " " + kids[i].color + " ");
            }
            System.out.println(" ");
        }
    }

    void bubbleSort(){
        System.out.println("冒泡排序");

        for(int i = 0; i< kids.length - 1; i++){
            for(int j = 0; j<kids.length - 1 - i;j++){
                if( kids[j].val > kids[j+1].val) {
                    Kid temp = kids[j];
                    kids[j] = kids[j+1];
                    kids[j+1] = temp;
                    System.out.println(
                            kids[i].name + ":" + i + "->" + j
                            +
                            kids[j].name + ":" + j + "->" + i
                    );
                }
            }
        }
    }

    public void binaryInsertSort(){
        System.out.println("二分排序");

        for(int i = 0;i<kids.length;i++){
            Kid temp = kids[i];

            int left = 0;
            int right = i-1;
            int middle = 0;

            while(left <= right){
                middle = (left + right)/2;//赋值
                if(temp.color.getValue() < kids[middle].color.getValue()){
                    right = middle-1;
                }else{
                    left = middle + 1;
                }
            }
            for(int j = i-1;j>=left;j--){

                int j_temp = j +1;
                kids[j+1] = kids[j];
                System.out.println(
                        kids[j+1].name + ":" + j_temp + "->" + j
                );
            }
            if(left != i ){
                kids[left] = temp;
                System.out.println(
                        kids[left].name + ":" + left + "->" + i
                );
            }
        }

    }

    public static void main(String[] args){

        GourdDoll gourdDoll = new GourdDoll();

        gourdDoll.outOrder();
        gourdDoll.bubbleSort();
        gourdDoll.show(true);

        gourdDoll.outOrder();
        gourdDoll.binaryInsertSort();
        gourdDoll.show(false);

    }
}
