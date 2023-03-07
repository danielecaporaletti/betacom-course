package prova.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClassReflection {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		
		TestReflection obj = new TestReflection();
		
		Class cls = obj.getClass();
		
		System.out.println("Il nome della calsse e' "+ cls.getName());
		
		//Constructor[] constructor =  cls.getConstructors();
		
		Method[] methods = cls.getMethods();
		
		for (Method method : methods)
            System.out.println(method.getName());
		
		
		Method[] declaredMethods = cls.getDeclaredMethods();
		
		for (Method method : declaredMethods)
            System.out.println(method.getName());
		
		Method metodo1 = cls.getMethod("Metodo1");
		
				
		
		  metodo1.setAccessible(true);
		  
		  metodo1.invoke(obj);
		  
		 
		  Method gino = cls.getMethod("Metodo2", int.class);
		  
		  
		
		  //metodo2.setAccessible(true);
		  
		  gino.invoke(obj, 2);
		 
		
		
		
		
		
		
		
		
		
		
		

	}

}

