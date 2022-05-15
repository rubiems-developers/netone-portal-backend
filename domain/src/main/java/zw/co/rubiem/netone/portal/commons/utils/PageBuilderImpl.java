package zw.co.rubiem.netone.portal.domain.commons.utils;

import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class PageBuilderImpl<T> implements PageBuilder<T> {

    @Override
    public Page<T> listToPage(List<T> listItems, Pageable pageable) {

        int start = (int) pageable.getOffset();

        int end = Math.min((start + pageable.getPageSize()), listItems.size());

        return new PageImpl<>(listItems.subList(start, end), pageable, listItems.size());
    }

    @Override
    public Page<T> collectionToPage(Collection<T> collectionItems, Pageable pageable) {

        val listItems = (List<T>) collectionItems;

        int start = (int) pageable.getOffset();

        int end = Math.min((start + pageable.getPageSize()), listItems.size());

        return new PageImpl<>(listItems.subList(start, end), pageable, listItems.size());
    }
}
