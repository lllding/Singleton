import java.lang.reflect.Constructor;

public class Singleton {
	private static boolean isInit = false;
	private static volatile Singleton instance;
	
	private Singleton() throws Exception{
		synchronized (Singleton.class) {
			if(!isInit){
				isInit = true;
			}else{
				throw new Exception("double instance error... ");
			}
		}
	}
	
	public static Singleton getInstance(){
		if(null == instance){
			synchronized (Singleton.class) {
				if(null == instance){
					try {
						instance = new Singleton();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return instance;
	}
	
	public static void main (String[] args) throws Exception{
//		Singleton s1 = Singleton.getInstance();
//		Singleton s2 = (Singleton) s1.clone();
//		System.out.println(s1  + "  " + s2);
		
		
		Constructor con = Singleton.class.getDeclaredConstructor();
		con.setAccessible(true);

		//通过反射获取实例
		Singleton instance = (Singleton)con.newInstance();
//		Singleton instance1 = (Singleton)con.newInstance();
//		System.out.println(instance   +  "  " + instance1);
		
		System.out.println(instance);
	}
}
