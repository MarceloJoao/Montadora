package io.github.MarceloJoao.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;
    public TodoValidator(TodoRepository repository){
        this.repository = repository;
    }

    public void validar(TodoEntity todo){
        if(existe(todo.getDescricao())){
            throw new IllegalArgumentException("Já existe um todo com esta descrição!");
        }
    }

    private boolean existe(String descricao){
       return repository.existsByDescricao(descricao);
    }
}
