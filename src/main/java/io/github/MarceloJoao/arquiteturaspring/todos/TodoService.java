package io.github.MarceloJoao.arquiteturaspring.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    public TodoService(TodoRepository todorepository, TodoValidator validator, MailSender mailSender){
        this.validator = validator;
        this.mailSender = mailSender;
        this.repository = todorepository;
    }

    public TodoEntity salvar(TodoEntity novoTodo){
        validator.validar(novoTodo);
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo){
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluido" : "Não concluido";
        mailSender.enviar("Todo de código" + todo.getDescricao() + "foi atualizado para" + status);
    }

    public TodoEntity buscar(Integer id){
        return repository.findById(id).orElse(null);
    }
}
