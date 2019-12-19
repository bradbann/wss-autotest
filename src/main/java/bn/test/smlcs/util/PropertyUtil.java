package bn.test.smlcs.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @date 2019年3月29日 下午4:43:42
 * @author zhaodong
 */
public class PropertyUtil {
	

	//读取Properties的全部信息
	public static Map<String, String> GetAllProperties(String filePath){
    	Map<String, String> map = new HashMap<String,String>();
        Properties pps = new Properties();
        InputStream in = PropertyUtil.class.getResourceAsStream(filePath);;
        try {
			pps.load(in);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        Enumeration<?> en = pps.propertyNames(); //得到配置文件的名字
        while(en.hasMoreElements()) {
            String strKey = (String) en.nextElement();
            String strValue = pps.getProperty(strKey);
            map.put(strKey, strValue);
        }
        
        return map;
        
    }
    
    
//    public void loadProps(){
//    	System.out.println("开始加载properties文件内容.......");
//        props = new Properties();
//        InputStream in = null;
//        try {
//            // 第一种，通过类加载器进行获取properties文件流-->
//            in = PropertyUtil.class.getClassLoader().getResourceAsStream("db.properties");
//            // 第二种，通过类进行获取properties文件流-->
//            //in = PropertyUtil.class.getResourceAsStream("/jdbc.properties");
//            props.load(in);
//        } catch (FileNotFoundException e) {
//            System.out.println("jdbc.properties文件未找到");
//        } catch (IOException e) {
//            System.out.println("出现IOException");
//        } finally {
//            try {
//                if(null != in) {
//                    in.close();
//                }
//            } catch (IOException e) {
//                System.out.println("jdbc.properties文件流关闭出现异常");
//            }
//        }
//        System.out.println("加载properties文件内容完成...........");
//        System.out.println("properties文件内容：" + props);
//    }
	

}
