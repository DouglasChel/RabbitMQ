package br.com.projAulaSpring;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    @Value("${queue.produto.name}")
    private String produtoQueue;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public Queue queue(){
        return new Queue(produtoQueue, true);
    }
}
