package byteCode.test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {
        public static void main(String[] args) throws IOException {
            ClassLoader loader=Thread.currentThread().getContextClassLoader();
            System.out.println(loader);         //输出AppClassLoader
            //下面这段没整明白什么用，先记录下来
            String resourceName= "byteCode/test/MyTest13.class";
            Enumeration<URL> urls=loader.getResources(resourceName);
            while(urls.hasMoreElements()){
                URL url=urls.nextElement();
                System.out.println(url);
        }
    }
}
