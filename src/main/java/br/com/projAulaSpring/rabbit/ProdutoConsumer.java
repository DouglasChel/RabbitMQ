package br.com.projAulaSpring.rabbit;
import br.com.projAulaSpring.service.ProdutoService;
import br.com.projAulaSpring.model.Produto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConsumer {
    @Autowired
    private ProdutoService produtoService;

    @RabbitListener(queues = {"${queue.produto.name}"})
    public void receive (@Payload Produto produto){
        System.out.println("Id: "+ produto.getId() + "\nNome: " + produto.getNome());
        //Inserir dado no Mongo
        produtoService.save(produto);
    }
}
