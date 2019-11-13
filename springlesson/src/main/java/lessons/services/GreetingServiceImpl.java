package lessons.services;

import org.springframework.context.ApplicationContext;

public class GreetingServiceImpl implements GreetingService {

    private ApplicationContext context;

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public String sayGreeting() {
        return "Greeting user!";
    }
}
