package org.serega.service;

import org.serega.model.GenericModel;
import org.serega.repositories.GenericRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public abstract class GenericService <T extends GenericModel> {
    private final GenericRepository<T> repository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public GenericService(GenericRepository<T> repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public void create(T entity) {
        repository.save(entity);
    }

    public void update(T entity) {
        repository.save(entity);
    }

    public T findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Пользователь с таким id: " + id + " - не найден"));
    }

    public void delete(long id) {
        T entity = findById(id);
        repository.delete(entity);//todo валидация (что произойдет.. если User-а с id нет)
    }
}
