# JarLoader
Simple way to load dot-jar libraries in runtime

```java
 File filename = new File("libsFolder");
 URLClassLoaderAccess loader = URLClassLoaderAccess.create((URLClassLoader) Main.class.getClassLoader());
 loader.addURL(filename.toURI().toURL());
```
