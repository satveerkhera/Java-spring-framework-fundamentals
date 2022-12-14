import com.ss.repository.HibernateSpeakerRepositoryImpl;
import com.ss.repository.SpeakerRepository;
import com.ss.service.SpeakerService;
import com.ss.service.SpeakerServiceImpl;
import com.ss.util.CalendarFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

@Configuration
@ComponentScan({"com.ss"})
public class AppConfig {

    @Bean(name = "cal")
    public CalendarFactory calFactory() {
        CalendarFactory factory = new CalendarFactory();
        factory.addDays(2);
        return factory;
    }

    @Bean
    public Calendar cal() throws  Exception {
        return  calFactory().getObject();
    }


    /* @Bean(name = "speakerService")
    @Scope(value= BeanDefinition.SCOPE_SINGLETON)
    //@Scope(value= BeanDefinition.SCOPE_PROTOTYPE)
    public SpeakerService getSpeakerService() {

        //SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
        SpeakerServiceImpl service = new SpeakerServiceImpl();
        //service.setRepository(getSpeakerRepository());
        return  service;
    }

    @Bean(name ="speakerRepository")
    public SpeakerRepository getSpeakerRepository(){
        return new HibernateSpeakerRepositoryImpl();
    }

    */
}
