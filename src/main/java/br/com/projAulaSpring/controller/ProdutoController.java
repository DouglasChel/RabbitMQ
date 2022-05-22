package br.com.projAulaSpring.controller;
import br.com.projAulaSpring.model.Produto;
import br.com.projAulaSpring.service.ProdutoService;
import br.com.projAulaSpring.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping(Constants.API_PRODUTO)
    public void save(@RequestBody Produto produto){
        produtoService.sendProdutoRabbit(produto);
    }

    @GetMapping(Constants.API_PRODUTO)
    public List<Produto> findAll(){
        return produtoService.findAll();
    }

    @PutMapping(Constants.API_PRODUTO)
    public void update(@RequestBody Produto produto){
        produtoService.save(produto);
    }

    @DeleteMapping(Constants.API_PRODUTO + "/{id}")
    public void delete(@PathVariable("id") String id){
        produtoService.delete(id);
    }

    @GetMapping(Constants.API_PRODUTO + "/{id}")
    public Optional<Produto> findById(@PathVariable("id") String id){
        return produtoService.findById(id);
    }
}
