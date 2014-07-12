package com.csc.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.csc.dao.ActorDAO;
import com.csc.models.Actor;
 

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	 
	        ActorDAO actorDAO = (ActorDAO) context.getBean("ActorDAO");
	        //Actor actor = new Actor(201, "Bala","Krishna");
	        //actorDAO.insert(actor);
	 
	        Actor actor1 = actorDAO.findByActorId(150);
	        System.out.println(actor1);
		
	        System.out.println(actor1.toString());
	}

}
