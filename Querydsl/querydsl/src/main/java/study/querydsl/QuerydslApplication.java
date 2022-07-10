package study.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@SpringBootApplication
public class QuerydslApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuerydslApplication.class, args);
	}




//	@Bean  //일단 요번 강의에서 강의자가 전체 빈 등록으로 안한다고 함
//	JPAQueryFactory jpaQueryFactory(EntityManager em) {
//		return new JPAQueryFactory(em);
//	}

}
