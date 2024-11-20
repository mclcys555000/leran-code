import java.util.Random;
import java.util.Scanner;

public class Role{
    String[] boyfaces= {"风流俊雅","气宇轩昂","相貌英俊","五官端正","相貌平平","一塌糊涂","面目狰狞"};
    String[] girlfaces ={"美奂绝伦","沉鱼落雁","婷婷玉立","身材娇好","相貌平平","相貌简陋","惨不忍睹"};
    String[] attacks_desc={
    "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
    "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
    "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
    "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
    "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
    "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
    };
    String[] injureds_desc={
    "结果%s退了半步，毫发无损",
    "结果给%s造成一处瘀伤",
    "结果一击命中，%s痛得弯下腰",
    "结果%s痛苦地闷哼了一声，显然受了点内伤",
    "结果%s摇摇晃晃，一跤摔倒在地",
    "结果%s脸色一下变得惨白，连退了好几步",
    "结果『轰』的一声，%s口中鲜血狂喷而出",
    "结果%s一声惨叫，像滩软泥般塌了下去"
    };
    private String name = "无名氏";
    private int hurtRanges = 20;
    private int damageLimit = 1;
    private double blood = 100;
    private double nowblood = blood;
    private double percentBlood = 1;
    private String gender = "不知道";
    private String face = boyfaces[6];
    private String absSex = "男";
    public Role(){
    }
    public Role(String name,double blood,int hurtRanges,String gender){
        Random r = new Random();
        this.name = name;
        if(blood >= 100){
            this.blood = blood;
        }
        nowblood = this.blood;
        this.hurtRanges = hurtRanges;
        if(gender == "男" || gender == "男士" || gender == "男儿" || gender == "男生" || gender == "男人" || gender  == "雄性" || gender == "公"){
            this.gender = gender;
            absSex = "男";
            setFace();
        }else if(gender == "女" || gender == "女士" || gender == "女子" || gender == "女生" || gender == "女人" || gender  == "雌性" || gender == "母"){
            this.gender = gender;
            absSex = "女";
            setFace();
        }else{
            System.out.println("该变量设置错误");
            absSex = "男";
            System.out.println("以自动设置成默认值");
        }
    }
    public Role(String name,double blood,String gender){
        Random r = new Random();
        this.name = name;
        if(blood >= 100){
            this.blood = blood;
        }
        nowblood = this.blood;
        if(gender == "男" || gender == "男士" || gender == "男儿" || gender == "男生" || gender == "男人" || gender  == "雄性" || gender == "公"){
            this.gender = gender;
            absSex = "男";
            setFace();
        }else if(gender == "女" || gender == "女士" || gender == "女子" || gender == "女生" || gender == "女人" || gender  == "雌性" || gender == "母"){
            this.gender = gender;
            absSex = "女";
            setFace();
        }else{
            System.out.println("该变量设置错误");
            absSex = "男";
            System.out.println("以自动设置成默认值");
        }
    }
    public Role(String name,double blood,int hurtRanges,int damageLimit,String gender){
        Random r = new Random();
        this.name = name;
        if(blood >= 100){
            this.blood = blood;
        }
        nowblood = this.blood;
        this.damageLimit = damageLimit;
        this.hurtRanges = hurtRanges;
        if(gender == "男" || gender == "男士" || gender == "男儿" || gender == "男生" || gender == "男人" || gender  == "雄性" || gender == "公"){
            this.gender = gender;
            absSex = "男";
            setFace();
        }else if(gender == "女" || gender == "女士" || gender == "女子" || gender == "女生" || gender == "女人" || gender  == "雌性" || gender == "母"){
            this.gender = gender;
            absSex = "女";
            setFace();
        }else{
            System.out.println("该变量设置错误");
            absSex = "男";
            System.out.println("以自动设置成默认值");
        }
    }
    public void setName(String name){
        this.name = name;
    }
    public void setBlood(double blood){
        this.blood = blood;
    }
    public void setHurtRanges(int hurtRange){
        if(hurtRange > (damageLimit + 1)){
            this.hurtRanges = hurtRanges;
        }
    }
    public String getName(){
        return name;
    }
    public double getBlood(){
        return blood;
    }
    public double getNowBlood(){
        return nowblood;
    }
    public void setNowBlood(double nowblood){
        this.nowblood = nowblood;
    }
    public int getHurtRanges(){
        return hurtRanges;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getFace(){
        return face;
    }
    public void setFace(){
        Random r = new Random();
        if(absSex == "男"){
            face = boyfaces[r.nextInt(boyfaces.length)];
        }else if(absSex == "女"){
            face = girlfaces[r.nextInt(girlfaces.length)];
        }else{
            face = boyfaces[6];
        }
    }
    public double getPercentBlood(){
        return percentBlood;
    }
    private double percentMath(){
        double pb;
        pb = nowblood / blood;
        percentBlood = pb;
        return pb;
    }
    public void attack(Role role){
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        double hurt = (double)((int)(((r.nextDouble((hurtRanges - damageLimit) + 1)) +  damageLimit)  * 100)) / 100;
        double reaminBlood = role.getNowBlood() - hurt;
        reaminBlood = reaminBlood > 0 ? reaminBlood : 0;
        role.setNowBlood(reaminBlood);
        double rpB = role.percentMath();
        int index = r.nextInt(attacks_desc.length);
        String KungFu = attacks_desc[index];
        System.out.printf(KungFu, this.getName(), role.getName());
        System.out.println();
        if(rpB > 0.9){
            System.out.printf(injureds_desc[0], role.getName());
        }else if(rpB > 0.8 && rpB <= 0.9){
            System.out.printf(injureds_desc[1], role.getName());
        }else if(rpB > 0.7 && rpB <= 0.8){
            System.out.printf(injureds_desc[2], role.getName());
        }else if(rpB > 0.6 && rpB <= 0.7){
            System.out.printf(injureds_desc[3], role.getName());
        }else if(rpB > 0.4 && rpB <= 0.6){
            System.out.printf(injureds_desc[4], role.getName());
        }else if(rpB > 0.2 && rpB <= 0.4){
            System.out.printf(injureds_desc[5], role.getName());
        }else if(rpB > 0.1 && rpB <= 0.2){
            System.out.printf(injureds_desc[6], role.getName());
        }else if(rpB < 0.1 || rpB == 0){
            System.out.printf(injureds_desc[7], role.getName());
        }
        System.out.println();
        System.out.println(this.getName() + "对" + role.getName() +"造成了" + hurt +"点伤害，");
        System.out.println();
        System.out.println(role.getName() + "还剩下" + role.getNowBlood() + "点血量");
        System.out.println(this.getName() + "还剩下" + this.getNowBlood() + "点血量");
        System.out.println();
        System.out.println("按回车键继续");
        String enter = sc.nextLine();
    }
    public void showRoleInfo(){
        System.out.println("姓名为：" + getName());
        System.out.println("血量为：" + getBlood());
        System.out.println("目前血量为：" + getNowBlood());
        System.out.println("性别为：" + getGender());
        System.out.println("长相为：" + getFace());
        System.out.println("伤害上限为：" + hurtRanges);
        System.out.println("伤害下限为：" + damageLimit);
    }
}