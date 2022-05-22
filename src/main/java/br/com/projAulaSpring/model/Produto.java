package br.com.projAulaSpring.model;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document
public class Produto implements Serializable {

    @Id
    private String _id;
    private String nome;

    public Produto() {
    }

    public Produto(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

