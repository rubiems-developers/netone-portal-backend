package zw.co.rubiem.netone.portal.domain.commons.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface PageBuilder<T> {

    Page<T> listToPage(List<T> listItems, Pageable pageable);

    Page<T> collectionToPage(Collection<T> collectionItems, Pageable pageable);

}
