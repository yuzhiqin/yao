package com.shu.yao.util;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

public class CustomClassLoader extends ClassLoader {

	 private String basedir; // 需要该类加载器直接加载的类文件的基目录
     private HashSet classNames; // 需要由该类加载器直接加载的类名
     
	  public CustomClassLoader(String basedir, String[] clazzNames) throws Exception {
          super(null); // 指定父类加载器为 null
          this.basedir = basedir;
  
          classNames = new HashSet();
          for (int i = 0; i < clazzNames.length; i++) {
              String name = clazzNames[i];
  
  
              StringBuffer sb = new StringBuffer(basedir);
              String className = name.contains(".") ? name.replace('.', File.separatorChar)+ ".class" : name+ ".class";
              sb.append(className);
  
  
              System.out.println("Load Class: baseDir:" + basedir + ",ClassName:" + name + ",Class file path:" + sb.toString());
  
              File classF = new File(sb.toString());
              FileInputStream fin = new FileInputStream(classF);
              byte[] raw = new byte[(int) classF.length()];
              fin.read(raw);
              fin.close();
  
              defineClass(name, raw, 0, raw.length);
  
  
              classNames.add(clazzNames[i]);
          }
      }
  
	  @Override
      protected Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
          Class cls = null;
          cls = findLoadedClass(name);
          if (!this.classNames.contains(name) && cls == null)
              cls = getSystemClassLoader().loadClass(name);
          if (cls == null)
              throw new ClassNotFoundException(name);
          if (resolve)
              resolveClass(cls);
          return cls;
      }
	  
	  public static void main(String[] args){
          new Timer().schedule(new TimerTask() {
  
              @Override
              public void run() {
                  try {
  
                      URL resource = CustomClassLoader.class.getResource("/");
                      String resourceFile = resource.getFile();
                      System.out.println(resourceFile);
                      // 每次都创建出一个新的类加载器
                      CustomClassLoader customClassLoader = new CustomClassLoader(
                              resourceFile, new String[] { "com.coding.classloader.Foo" });
                      Class<?> cls = customClassLoader.loadClass("com.coding.classloader.Foo");
  
  
  //                    ClassLoader classLoader1 = cls.getClassLoader();//com.coding.classloader.CustomClassLoader
  //                    Class<?> cls2 = Class.forName("com.coding.classloader.Foo");
  //                    ClassLoader classLoader = cls2.getClassLoader();//sun.misc.Launcher$AppClassLoader
  //                    System.out.println(classLoader+":"+classLoader1);
  
                      Object foo = cls.newInstance();
  
                      Method m = foo.getClass().getMethod("sayHi", new Class[] {});
                      m.invoke(foo, new Object[] {});
                  } catch (Exception ex) {
                      ex.printStackTrace();
                  }
              }
          }, 0, 1000L);
      }
	  
}
