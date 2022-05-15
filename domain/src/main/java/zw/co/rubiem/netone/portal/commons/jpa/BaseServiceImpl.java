package zw.co.rubiem.netone.portal.commons.jpa;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import zw.co.rubiem.netone.portal.commons.exceptions.InvalidRequestException;

import java.util.Collection;
import java.util.NoSuchElementException;

public abstract class BaseServiceImpl<T, C, U> implements BaseService<T, C, U> {

    protected final BaseDao<T> repository;

    public BaseServiceImpl(BaseDao<T> repository) {
        this.repository = repository;
    }

    public T findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> {
            return new NoSuchElementException(this.getEntityClass().getSimpleName() + " record not found.");
        });
    }

    @Transactional
    public void delete(Long id) {
        try {
            this.repository.deleteById(id);
        } catch (DataIntegrityViolationException var3) {
            throw new InvalidRequestException("You can not delete this record as it might be used by another record");
        }
    }

    public Page<T> findAll(Pageable pageable, String searchQuery) {
        return this.repository.findAll(pageable);
    }

    public Collection<T> findAll() {
        return this.repository.findAll();
    }
    /*public String findString(String string) {
        return string;
    }*/
    protected abstract Class<T> getEntityClass();

}

