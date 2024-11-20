public class GameTest{
    public static void main(String[] args){
        Role r1 = new Role("沸羊羊",200,30,5,"公");
        Role r2 = new Role("美羊羊",100,20,2,"母");
        r1.showRoleInfo();
        System.out.println();
        r2.showRoleInfo();
        System.out.println();
        System.out.println("按回车键继续");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int count = 0 ;true;){
            count++;
            r1.attack(r2);
            if(r2.getNowBlood() <= 0){
                System.out.println(r1.getName() + "K.O了" + r2.getName());
                break;
            }
            count++;
            r2.attack(r1);
            if(r1.getNowBlood() <= 0){
                System.out.println(r2.getName() + "K.O了" + r1.getName());
                break;
            }
        }
    }
}