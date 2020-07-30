package lec1Java;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BookTest {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Book book = ctx.getBean("book", Book.class);
		
		book.read();
		
		
		
		ctx.close();
	}

}
